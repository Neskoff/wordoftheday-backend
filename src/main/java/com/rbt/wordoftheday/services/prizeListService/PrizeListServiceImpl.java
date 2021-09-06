package com.rbt.wordoftheday.services.prizeListService;

import com.rbt.wordoftheday.domain.PrizeList;
import com.rbt.wordoftheday.repositories.PrizeListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PrizeListServiceImpl implements PrizeListService {
    @Autowired
    private PrizeListRepository prizeListRepository;

    @Override
    public PrizeList getCurrentPrizeList() {
        return this.prizeListRepository.findByIsactiveIsTrue();
    }

    @Override
    public List<PrizeList> getInactivePrizeLists() {
        return this.prizeListRepository.findAllByIsactiveIsFalse();
    }

    @Override
    public boolean insertPrizeList(PrizeList prizeList) {
        return this.prizeListRepository.insertPrizeList(prizeList.isIsactive()) != 0 ;
    }

    @Override
    public boolean resetPrizeList() {
        return this.prizeListRepository.resetPrizeList() != 0;
    }

    @Override
    public boolean updateCurrentPrizeList(int Id) {
        return this.prizeListRepository.updateCurrentPrizeList(Id) != 0;
    }
}
