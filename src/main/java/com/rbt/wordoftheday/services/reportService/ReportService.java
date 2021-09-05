package com.rbt.wordoftheday.services.reportService;

import com.rbt.wordoftheday.domain.Report;

public interface ReportService {
    Report getCampaignReport(int id);
    boolean insertCampaignReport(Report report);
    boolean updateCampaignReport(Report report);
}
