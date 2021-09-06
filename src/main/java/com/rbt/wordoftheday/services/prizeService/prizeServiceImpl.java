package com.rbt.wordoftheday.services.prizeService;

import com.rbt.wordoftheday.domain.Prize;
import com.rbt.wordoftheday.repositories.PrizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class prizeServiceImpl implements PrizeService {
    @Autowired
    private PrizeRepository prizeRepository;

    @Override
    public List<Prize> findAllByPrizeListId(int id) {
        return this.prizeRepository.findAllByPrizelistid(id);
    }

    @Override
    public boolean updateTimesSelected(Prize prize) {
        return this.prizeRepository.updateTimesSelected(prize.getId()) != 0;
    }

    @Override
    public boolean insertNewPrize(Prize prize) {
        return this.prizeRepository.insertPrize(prize.getPrizelistid(), prize.getPrize(), 0) != 0;
    }

    @Override
    public boolean deletePrize(int Id) {
        return this.prizeRepository.deleteById(Id) != 0;
    }
}
