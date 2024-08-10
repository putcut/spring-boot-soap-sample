package com.example.server;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.okomes.GetHinshuRequest;
import com.example.okomes.GetHinshuResponse;
import com.example.okomes.Hinshu;

@Endpoint
public class OkomeEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/okomes";

    private final OkomeRepository okomeRepository;

    public OkomeEndpoint(OkomeRepository okomeRepository) {
        this.okomeRepository = okomeRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getHinshuRequest")
    @ResponsePayload
    public GetHinshuResponse getHinshu(
            @RequestPayload GetHinshuRequest request) throws Exception {
        GetHinshuResponse response = new GetHinshuResponse();
        Hinshu hinshu = okomeRepository.findHinshu(request.getId());
        if (hinshu == null) {
            throw new OkomeInvalidArgumentException("Hinshu not found. id: " + request.getId());
        }
        response.setHinshu(hinshu);

        return response;
    }
}
