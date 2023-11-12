package com.mybooks.configuration;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class TrafficSimulator {

    private final RestTemplate restTemplate;

    public TrafficSimulator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(cron = "*/13 7,23 * * *", zone = "Europe/Sofia")
    public void sendGetRequest() {
        String URL = "https://my-books-server.onrender.com";

        restTemplate.getForObject(URL, String.class);

        System.out.println("Wakeup request successfully sent at: " +
                LocalDate.now().format(DateTimeFormatter.ofPattern("dd-MMM-yyyy HH:mm:ss")));

    }
}
