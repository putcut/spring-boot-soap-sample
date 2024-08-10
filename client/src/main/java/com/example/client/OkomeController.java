package com.example.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OkomeController {

    private final OkomeClient okomeClient;

    public OkomeController(OkomeClient okomeClient) {
        this.okomeClient = okomeClient;
    }

    @GetMapping("/okome/hinshu/{id}")
    public HinshuJson getHinshu(@PathVariable int id) {
        return okomeClient.getHinshu(id);
    }
}
