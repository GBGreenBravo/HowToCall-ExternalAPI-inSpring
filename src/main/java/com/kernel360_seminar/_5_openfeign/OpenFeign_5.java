package com.kernel360_seminar._5_openfeign;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenFeign_5 {

    @Value("${naver-api.client.id}")
    private String apiId;

    @Value("${naver-api.client.secret}")
    private String apiSecret;

    private final NaverApiClient naverApiClient;

    public void openFeign() {
        ResponseEntity<String> response = naverApiClient.searchBlog("Kernel360", apiId, apiSecret);

        System.out.println(response.getBody());
    }
}
