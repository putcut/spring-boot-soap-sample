package com.example.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.wsdl.GetHinshuRequest;
import com.example.wsdl.GetHinshuResponse;
import com.example.wsdl.Hinshu;

public class OkomeClient extends WebServiceGatewaySupport {

    public HinshuJson getHinshu(int id) {
        GetHinshuRequest request = new GetHinshuRequest();
        request.setId(id);

        GetHinshuResponse response = (GetHinshuResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://example.com/okomes/GetHinshuRequest"));

        Hinshu hinshu = response.getHinshu();

        return new HinshuJson(hinshu.getId(), hinshu.getName());
    }
}
