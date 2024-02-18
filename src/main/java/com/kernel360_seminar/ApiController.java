package com.kernel360_seminar;

import com.kernel360_seminar._1_url_connection.UrlConnection;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
class ApiController {

    private final UrlConnection urlConnection;

    @GetMapping("/1")
    public ResponseEntity.BodyBuilder urlConnection() throws IOException {
        urlConnection.urlConnection();
        return ResponseEntity.ok();
    }

    @GetMapping("/5")
    public ResponseEntity.BodyBuilder openFeign() {
//        apiService.openFeign();
        return ResponseEntity.ok();
    }
}
