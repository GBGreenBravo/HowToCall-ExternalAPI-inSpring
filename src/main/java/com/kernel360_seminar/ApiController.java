package com.kernel360_seminar;

import com.kernel360_seminar._1_url_connection.UrlConnection_1;
import com.kernel360_seminar._2_http_client.HttpClient_2;
import com.kernel360_seminar._3_rest_template.RestTemplate_3;
import com.kernel360_seminar._4_web_client.WebClient_4;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
class ApiController {

    private final UrlConnection_1 urlConnection_1;
    private final HttpClient_2 httpClient_2;
    private final RestTemplate_3 restTemplate_3;
    private final WebClient_4 webClient_4;

    @GetMapping("/1")
    public ResponseEntity.BodyBuilder urlConnection() throws IOException {
        urlConnection_1.urlConnection();
        return ResponseEntity.ok();
    }

    @GetMapping("/2")
    public ResponseEntity.BodyBuilder httpClient() throws IOException {
        httpClient_2.httpClient();
        return ResponseEntity.ok();
    }

    @GetMapping("/3")
    public ResponseEntity.BodyBuilder restTemplate() {
        restTemplate_3.restTemplate();
        return ResponseEntity.ok();
    }

    @GetMapping("/4")
    public ResponseEntity.BodyBuilder webClient() {
        webClient_4.webClient();
        return ResponseEntity.ok();
    }
}
