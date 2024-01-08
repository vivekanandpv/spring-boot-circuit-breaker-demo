package com.vivekanandpv.downstreamservice.apis;

import com.vivekanandpv.downstreamservice.models.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/downstream")
public class DownstreamApi {
    @GetMapping
    public ResponseEntity<Book> get() {
        return ResponseEntity.ok(new Book(14, "Learning Spring", 800, 1024));
    }
}
