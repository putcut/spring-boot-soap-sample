package com.example.client;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.example.wsdl.GetPokemonRequest;
import com.example.wsdl.GetPokemonResponse;
import com.example.wsdl.Pokemon;

public class PokemonClient extends WebServiceGatewaySupport {

    public PokemonJson getPokemon(int id) {
        GetPokemonRequest request = new GetPokemonRequest();
        request.setId(id);

        GetPokemonResponse response = (GetPokemonResponse) getWebServiceTemplate()
                .marshalSendAndReceive(request, new SoapActionCallback("http://example.com/pokemons/GetPokemonRequest"));

        Pokemon pokemon = response.getPokemon();

        return new PokemonJson(pokemon.getId(), pokemon.getName(), pokemon.getType());
    }
}
