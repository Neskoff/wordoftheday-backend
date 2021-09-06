package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.Prize;
import com.rbt.wordoftheday.domain.PrizeList;
import com.rbt.wordoftheday.services.prizeListService.PrizeListService;
import com.rbt.wordoftheday.services.prizeService.PrizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prizes")
public class PrizeListResource {
    @Autowired
    private PrizeListService prizeListService;
    @Autowired
    private PrizeService prizeService;

    @GetMapping("/")
    public ResponseEntity<List<Prize>> allPrizes() {
        PrizeList currentPrizeList = prizeListService.getCurrentPrizeList();
        return ResponseEntity.ok(this.prizeService.findAllByPrizeListId(currentPrizeList.getId()));
    }

    @PutMapping("/timesSelected")
    public ResponseEntity<Boolean> updateTimesSelected(@RequestBody Prize prize) {
        return ResponseEntity.ok(this.prizeService.updateTimesSelected(prize));
    }
}
