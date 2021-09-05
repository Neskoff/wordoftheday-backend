package com.rbt.wordoftheday.services.prizeListService;

import com.rbt.wordoftheday.domain.PrizeList;

import java.util.List;

public interface PrizeListService {
    PrizeList getCurrentPrizeList();
    List<PrizeList> getInactivePrizeLists();
    boolean insertPrizeList(PrizeList prizeList);
    boolean resetPrizeList();
    boolean updateCurrentPrizeList(int Id);
}
