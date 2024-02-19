package com.kernel360_seminar._6_rest_client;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Service
public class RestClient_6 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    public void restClient() {
        String text = URLEncoder.encode("Kernel360", StandardCharsets.UTF_8);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

        RestClient restClient = RestClient.create();

        String response = restClient.get()
                .uri(apiURL)
                .header("X-Naver-Client-Id", apiId)
                .header("X-Naver-Client-Secret", apiSecret)
                .retrieve()
                .body(String.class);

        System.out.println(response);
    }
}
