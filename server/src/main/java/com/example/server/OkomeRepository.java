package com.example.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.okomes.Hinshu;

@Component
public class OkomeRepository {

    private static Map<Integer, Hinshu> hinshues;

    static {
        hinshues = new HashMap<>();

        Hinshu koshihikari = new Hinshu();
        koshihikari.setId(1);
        koshihikari.setName("コシヒカリ");
        hinshues.put(1, koshihikari);

        Hinshu hinohikari = new Hinshu();
        hinohikari.setId(2);
        hinohikari.setName("ヒノヒカリ");
        hinshues.put(2, hinohikari);

        Hinshu akitaKomachi = new Hinshu();
        akitaKomachi.setId(3);
        akitaKomachi.setName("あきたこまち");
        hinshues.put(3, akitaKomachi);
    }

    public Hinshu findHinshu(int id) {
        return hinshues.get(id);
    }
}
