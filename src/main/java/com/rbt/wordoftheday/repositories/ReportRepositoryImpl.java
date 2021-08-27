package com.rbt.wordoftheday.repositories;

import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.mappers.ReportMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReportRepositoryImpl implements ReportRepository{
    private static final String GET_REPORT = "SELECT * FROM Reports WHERE CampaignId = ?";
    private static final String INSERT_REPORT = "INSERT INTO Reports (CampaignId, NoUsers, NoCorrect, NoFail) " +
            "VALUES(?,?,?,?)";
    private static final String UPDATE_REPORT = "UPDATE Reports SET NoUsers = ?, NoCorrect = ?, NoFail = ? " +
            "WHERE CampaignId = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Report getCampaignReport(int id) {
        return this.jdbcTemplate.queryForObject(GET_REPORT, new ReportMapper(), id);
    }

    @Override
    public int insertCampaignReport(Report report) {
        return this.jdbcTemplate.update(INSERT_REPORT,report.getCampaignId(), report.getNoUsers(),
                report.getNoCorrect(), report.getNoFail());
    }

    @Override
    public int updateCampaignReport(Report report) {
        return this.jdbcTemplate.update(UPDATE_REPORT,report.getCampaignId(), report.getNoUsers(),
                report.getNoCorrect(), report.getNoFail());
    }
}
