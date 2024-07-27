package com.example.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.support.interceptor.ClientInterceptor;
import org.springframework.ws.soap.security.wss4j2.Wss4jSecurityInterceptor;

@Configuration
public class ClientConfig {

    @Bean
    Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.wsdl"); // 自動生成したクラスのパッケージを指定
        return marshaller;
    }

    @Bean
    PokemonClient pokemonClient(Jaxb2Marshaller marshaller) {
        PokemonClient client = new PokemonClient();
        client.setDefaultUri("http://host.docker.internal:8080/ws/pokemons");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        client.setInterceptors(new ClientInterceptor[] { securityInterceptor() });
        return client;
    }

    @Bean
    Wss4jSecurityInterceptor securityInterceptor() {
        Wss4jSecurityInterceptor securityInterceptor = new Wss4jSecurityInterceptor();
        securityInterceptor.setSecurementActions("UsernameToken");
        securityInterceptor.setSecurementUsername("user");
        securityInterceptor.setSecurementPassword("password");
        return securityInterceptor;
    }
}
