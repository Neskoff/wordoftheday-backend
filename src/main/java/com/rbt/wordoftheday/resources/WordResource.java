package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.services.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/words")
public class WordResource {
    @Autowired
    private WordService wordService;

    @GetMapping("/wotd")
    public ResponseEntity<Word> getWOTD()
    {
        return ResponseEntity.ok(this.wordService.getWOTD());
    }
}
