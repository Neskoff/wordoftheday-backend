package com.rbt.wordoftheday.mappers;

import com.rbt.wordoftheday.domain.Report;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportMapper implements RowMapper<Report> {
    @Override
    public Report mapRow(ResultSet resultSet, int i) throws SQLException {
        Report report = new Report();
        report.setCampaignId(resultSet.getInt("CampaignId"));
        report.setNoUsers(resultSet.getInt("NoUsers"));
        report.setNoCorrect(resultSet.getInt("NoCorrect"));
        report.setNoFail(resultSet.getInt("NoFail"));
        return report;
    }
}
