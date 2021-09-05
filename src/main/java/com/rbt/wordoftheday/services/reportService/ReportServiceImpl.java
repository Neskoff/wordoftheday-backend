package com.rbt.wordoftheday.services.reportService;

import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.repositories.ReportRepository;
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
       return this.reportRepository.insertCampaignReport(report.CampaignId(), report.getNoUsers(),
               report.getNoCorrect(), report.getNoFail()) != 0;
    }

    @Override
    public boolean updateCampaignReport(Report report) {
        return this.reportRepository.updateCampaignReport(report.CampaignId(), report.getNoUsers(),
                report.getNoCorrect(), report.getNoFail()) != 0;
    }
}
