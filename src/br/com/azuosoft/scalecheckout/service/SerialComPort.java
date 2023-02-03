package br.com.azuosoft.scalecheckout.service;

import gnu.io.CommPortIdentifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Leandro
 */
public class SerialComPort {

    private List<String> ports;
    private final Enumeration portList;

    public SerialComPort() {
        this.ports = new ArrayList<>();
        this.portList = CommPortIdentifier.getPortIdentifiers();
    }

    public List<String> listPorts() {
        ports = (List<String>) Collections.list(portList).stream()
                .map(p -> ((CommPortIdentifier) p).getName())
                .collect(Collectors.toList());

        return ports;
    }

    public boolean portExists(String comPort) {
        return ports.stream().
                filter(p -> p.equalsIgnoreCase(comPort))
                .findAny()
                .isPresent();
    }

}
