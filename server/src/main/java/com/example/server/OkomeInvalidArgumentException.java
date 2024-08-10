package com.example.server;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://www.example.com/okomes}0001")
public class OkomeInvalidArgumentException extends Exception {

    public OkomeInvalidArgumentException(String message) {
        super(message);
    }
}
