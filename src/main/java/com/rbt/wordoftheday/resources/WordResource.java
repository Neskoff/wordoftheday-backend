package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.Word;
import com.rbt.wordoftheday.services.wordService.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/words")
public class WordResource {
    @Autowired
    WordService wordService;

    @GetMapping("/")
    public ResponseEntity<List<Word>> allWords() {
        return ResponseEntity.ok(this.wordService.allWords());
    }

    @GetMapping("/wordOfTheDay")
    public ResponseEntity<Word> wordOfTheDay() {
        return ResponseEntity.ok(this.wordService.findByWordOfTheDayIsTrue());
    }

    @GetMapping("/resetWordOfTheDay")
    public ResponseEntity<Boolean> resetWordOfTheDay() {
        return ResponseEntity.ok(this.wordService.resetWordOfTheDay());
    }

    @PostMapping("/")
    public ResponseEntity<Boolean> insertWordOfTheDay(@RequestBody Word word) {
        return ResponseEntity.ok(this.wordService.insertWordOfTheDay(word));
    }

    @PutMapping("/")
    public ResponseEntity<Boolean> updateWordOfTheDay(@RequestBody String word) {
        return ResponseEntity.ok(this.wordService.updateWordOfTheDay(word));
    }
}
