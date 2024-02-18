package com.kernel360_seminar._4_web_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class WebClient_4 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    public void webClient() {
        String text = URLEncoder.encode("그린팩토리", StandardCharsets.UTF_8);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

        WebClient webClient = WebClient.builder().defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader("X-Naver-Client-Id", apiId)
                .defaultHeader("X-Naver-Client-Secret", apiSecret)
                .build();

        Mono<String> response = webClient.get()
                .uri(apiURL)
                .retrieve()
                .bodyToMono(String.class);

        String responseBody = response.block();
        System.out.println(responseBody);
    }
}
