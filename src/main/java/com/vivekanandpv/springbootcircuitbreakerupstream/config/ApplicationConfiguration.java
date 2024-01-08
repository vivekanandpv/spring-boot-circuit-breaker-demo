package com.vivekanandpv.springbootcircuitbreakerupstream.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    private final String downstreamUrl;

    public ApplicationConfiguration(@Value("${app.downstream.url}")String downstreamUrl) {
        this.downstreamUrl = downstreamUrl;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplateBuilder().rootUri(downstreamUrl).build();
    }
}
