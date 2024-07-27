package com.example.server;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

@SoapFault(faultCode = FaultCode.CUSTOM, customFaultCode = "{http://www.example.com/pokemons}0001")
public class PokemonsInvalidArgumentException extends Exception {

    public PokemonsInvalidArgumentException(String message) {
        super(message);
    }
}
