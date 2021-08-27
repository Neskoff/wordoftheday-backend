package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Report;

public interface ReportRepository {
    Report getCampaignReport(int id);
    int insertCampaignReport(Report report);
    int updateCampaignReport(Report report);

}
