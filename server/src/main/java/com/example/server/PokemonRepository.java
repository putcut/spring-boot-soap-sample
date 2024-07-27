package com.example.server;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.pokemons.Pokemon;

@Component
public class PokemonRepository {

    private static final Map<Integer, Pokemon> pokemons = new HashMap<>(){
        {
            Pokemon pikachu = new Pokemon();
            pikachu.setId(25);
            pikachu.setName("Pikachu");
            pikachu.setType("Denki");
            put(25, pikachu);

            Pokemon doragonite = new Pokemon();
            doragonite.setId(149);
            doragonite.setName("Doragonite");
            doragonite.setType("Doragon");
            put(149, doragonite);

            Pokemon slowbro = new Pokemon();
            slowbro.setId(80);
            slowbro.setName("Slowbro");
            slowbro.setType("Mizu");
            put(80, slowbro);

            Pokemon pidgeotto = new Pokemon();
            pidgeotto.setId(17);
            pidgeotto.setName("Pidgeotto");
            pidgeotto.setType("Hikou");
        }
    };

    public Pokemon findPokemon(int id) {
        return pokemons.get(id);
    }
}
