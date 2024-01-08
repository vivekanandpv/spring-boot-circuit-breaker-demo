package com.vivekanandpv.springbootcircuitbreakerupstream.apis;

import com.vivekanandpv.springbootcircuitbreakerupstream.models.Book;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@RestController
@RequestMapping("api/v1/upstream")
public class UpstreamApi {
    private final RestTemplate restTemplate;

    public UpstreamApi(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    @CircuitBreaker(name = "upstream", fallbackMethod = "getFallback")
    public ResponseEntity<Map<String, String>> get() {
        ResponseEntity<Book> responseEntity = restTemplate.getForEntity("/api/v1/downstream", Book.class);
        return ResponseEntity.ok(Map.of("book", responseEntity.getBody().toString()));
    }

    public ResponseEntity<Map<String, String>> getFallback(RuntimeException exception) {
        return ResponseEntity.ok(Map.of("error", exception.getMessage()));
    }
}
