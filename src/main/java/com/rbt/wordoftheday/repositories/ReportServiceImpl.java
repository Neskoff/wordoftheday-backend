package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.services.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ReportServiceImpl implements ReportService {
    @Autowired
    private ReportRepository reportRepository;

    @Override
    public Report getCampaignReport(int id) {
        return this.reportRepository.getCampaignReport(id);
    }

    @Override
    public boolean insertCampaignReport(Report report) {
        int resultSet = this.reportRepository.insertCampaignReport(report);
        if (resultSet != 0)
            return true;
        return false;
    }

    @Override
    public boolean updateCampaignReport(Report report) {
        int resultSet = this.reportRepository.updateCampaignReport(report);
        if (resultSet != 0)
            return true;
        return false;
    }
}
