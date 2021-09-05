package com.rbt.wordoftheday.services.prizeService;

import com.rbt.wordoftheday.domain.Prize;

import java.util.List;

public interface PrizeService {
    List<Prize> findAllByPrizeListId(int id);
    boolean updateTimesSelected(Prize prize);
    boolean insertNewPrize(Prize prize);
    boolean deletePrize(int Id);
}
