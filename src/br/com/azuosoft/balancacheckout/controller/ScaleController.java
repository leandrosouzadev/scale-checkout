package br.com.azuosoft.balancacheckout.controller;

import br.com.azuosoft.balancacheckout.model.ScaleModelType;
import br.com.azuosoft.balancacheckout.service.ScaleService;
import br.com.azuosoft.balancacheckout.service.SerialComPort;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Leandro
 */
public class ScaleController {

    private final ScaleService scaleService;
    private final SerialComPort serialComPort;
    private String port;
    private ScaleModelType scaleModelType;

    public ScaleController() {
        scaleService = new ScaleService();
        serialComPort = new SerialComPort();
    }

    public String readWeigth() {
        return scaleService.readWeight(port, scaleModelType);
    }

    public List<String> getPorts() {
        return serialComPort.listPorts();
    }

    public List<ScaleModelType> getScaleModels() {
        return Arrays.asList(ScaleModelType.values());
    }

    public void setPort(String port) {
        this.port = port;
    }

    public void setScaleModelType(String scaleModelType) {
        this.scaleModelType = ScaleModelType.valueOf(scaleModelType);
    }        
}
