package com.example.client;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PokemonController {

    private final PokemonClient pokemonClient;

    public PokemonController(PokemonClient pokemonClient) {
        this.pokemonClient = pokemonClient;
    }

    @GetMapping("/pokemon/{id}")
    public PokemonJson getPokemon(@PathVariable int id) {
        return pokemonClient.getPokemon(id);
    }
}
