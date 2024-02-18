package com.kernel360_seminar._3_rest_template;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

@Service
public class RestTemplate_3 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    public void restTemplate() {
        String text = URLEncoder.encode("Kernel360", StandardCharsets.UTF_8);
        String apiURL = "https://openapi.naver.com/v1/search/blog?query=" + text;

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.add("X-Naver-Client-Id", apiId);
        headers.add("X-Naver-Client-Secret", apiSecret);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(apiURL, HttpMethod.GET, entity, String.class);
        System.out.println(response.getBody());
    }
}
