package com.kernel360_seminar._5_openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naverApiClient", url = "https://openapi.naver.com")
public interface NaverApiClient {

    @GetMapping("/v1/search/blog")
    ResponseEntity<String> searchBlog(
            @RequestParam("query") String query,
            @RequestHeader("X-Naver-Client-Id") String clientId,
            @RequestHeader("X-Naver-Client-Secret") String clientSecret
    );

    @GetMapping("/v1/search/news")
    ResponseEntity<String> searchNews(
            @RequestParam("query") String query,
            @RequestHeader("X-Naver-Client-Id") String clientId,
            @RequestHeader("X-Naver-Client-Secret") String clientSecret
    );
}
