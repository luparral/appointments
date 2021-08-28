package com.sesame.appointments.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {

        this.restTemplate = restTemplateBuilder.build();
    }

    public String getAppointmentsPlainJSON() {
        String url = "https://us-central1-sesame-care-dev.cloudfunctions.net/sesame_programming_test_api";
        return this.restTemplate.getForObject(url, String.class);
    }
}
