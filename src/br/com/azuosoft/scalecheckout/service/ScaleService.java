package br.com.azuosoft.scalecheckout.service;

import br.com.azuosoft.scalecheckout.model.ScaleModelType;
import br.com.azuosoft.scalecheckout.model.ElginCommands;
import br.com.azuosoft.scalecheckout.model.FilizolaCommands;
import gnu.io.CommPortIdentifier;
import gnu.io.NoSuchPortException;
import gnu.io.PortInUseException;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import gnu.io.UnsupportedCommOperationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.TooManyListenersException;
import java.util.logging.Level;
import java.util.logging.Logger;
import br.com.azuosoft.scalecheckout.model.IScaleCommands;
import br.com.azuosoft.scalecheckout.model.ToledoCommands;

/**
 *
 * @author Leandro
 */
public class ScaleService {

    private String port;
    private ScaleModelType scaleModelType;
    private IScaleCommands scaleCommands;
    private SerialPort serialPort;
    private String obtainedValue;
    private InputStream inputStream;
    private OutputStream outputStream;

    public ScaleService() {
        this.obtainedValue = "";
    }

    public String readWeight(String port, ScaleModelType scaleModelType) {
        try {
            this.port = port;
            this.scaleModelType = scaleModelType;
            this.scaleCommands = getCommands();

            openPort();
            addEventListener();            
            
            sendCommand(scaleCommands.getWeight());
            closePort();

            checkReturn();
        } catch (PortInUseException ex) {
            throw new RuntimeException(String.format("A porta %s já está em uso.", port), ex);
        } catch (NoSuchPortException ex) {
            throw new RuntimeException(String.format("A porta %s não foi encontrada.", port), ex);
        } catch (UnsupportedCommOperationException | IOException | TooManyListenersException | InterruptedException ex) {
            throw new RuntimeException("Problemas ao ler peso da balança", ex);
        }

        return obtainedValue;
    }

    private IScaleCommands getCommands() {
        switch (scaleModelType) {
            case FILIZOLA:
                return new FilizolaCommands();
            case TOLEDO:
                return new ToledoCommands();
            case ELGIN:
                return new ElginCommands();
        }

        throw new RuntimeException("Modelo informado não é suportado.");
    }

    private void openPort() throws NoSuchPortException, PortInUseException, UnsupportedCommOperationException {
        CommPortIdentifier portIdentifier = CommPortIdentifier.getPortIdentifier(port);
        serialPort = (SerialPort) portIdentifier.open(ScaleService.class.getName(), 2000);
        serialPort.setSerialPortParams(9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_2, SerialPort.PARITY_NONE);
    }

    private void closePort() throws InterruptedException, IOException {
        Thread.sleep(1000);

        inputStream.close();
        outputStream.close();
        serialPort.close();
    }

    private void addEventListener() throws IOException, TooManyListenersException {
        inputStream = serialPort.getInputStream();
        serialPort.notifyOnDataAvailable(true);
        serialPort.addEventListener(serialEvent(inputStream));
    }

    private void sendCommand(byte[] value) throws IOException, InterruptedException {
        outputStream = serialPort.getOutputStream();
        outputStream.write(value);

        Thread.sleep(5);

        outputStream.flush();
    }

    private SerialPortEventListener serialEvent(InputStream inputStream) throws IOException {
        return (SerialPortEvent event) -> {
            if (event.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
                try {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder = getValue(stringBuilder, inputStream);

                    obtainedValue = stringBuilder.toString();
                } catch (IOException ex) {
                    Logger.getLogger(ScaleService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
    }

    private StringBuilder getValue(StringBuilder stringBuilder, InputStream inputStream) throws IOException {
        int newData = inputStream.read();

        if (newData != -1) {
            stringBuilder.append((char) newData);
            stringBuilder = getValue(stringBuilder, inputStream);
        }

        return stringBuilder;
    }

    private void checkReturn() {        
        checkOverweight(obtainedValue);
        checkUnstableWeight(obtainedValue);
        checkNegativeweight(obtainedValue);
        
        obtainedValue = obtainedValue.replaceAll("\\D", "");
        checkReturnObtained(obtainedValue);
    }

    private void checkReturnObtained(String value) {
        if (value == null || "".equals(value)) {
            throw new RuntimeException("Não foi possivel ler o peso! Nenhuma informação foi retornada.");
        }
    }

    private void checkOverweight(String value) {
        if (value != null && value.contains("SSSSS")) {
            throw new RuntimeException("A balança está com pesso além da capacidade.");
        }
    }

    private void checkUnstableWeight(String value) {
        if (value != null && value.contains("IIIII")) {
            throw new RuntimeException("A balança está com o pesso instável.");
        }
    }

    private void checkNegativeweight(String value) {
        if (value != null && value.contains("NNNNN")) {
            throw new RuntimeException("A balança está com o pesso negativo.");
        }
    }
}
