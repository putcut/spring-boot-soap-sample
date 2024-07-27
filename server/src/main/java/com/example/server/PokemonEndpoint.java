package com.example.server;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.example.pokemons.GetPokemonRequest;
import com.example.pokemons.GetPokemonResponse;
import com.example.pokemons.Pokemon;

@Endpoint
public class PokemonEndpoint {
    private static final String NAMESPACE_URI = "http://www.example.com/pokemons";

    private final PokemonRepository pokemonRepository;

    public PokemonEndpoint(PokemonRepository pokemonRepository) {
        this.pokemonRepository = pokemonRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPokemonRequest")
    @ResponsePayload
    public GetPokemonResponse getPokemon(
            @RequestPayload GetPokemonRequest request) throws Exception {
        GetPokemonResponse response = new GetPokemonResponse();
        Pokemon pokemon = pokemonRepository.findPokemon(request.getId());
        if (pokemon == null) {
            throw new PokemonsInvalidArgumentException("Pokemon not found. id: " + request.getId());
        }
        response.setPokemon(pokemon);

        return response;
    }
}
