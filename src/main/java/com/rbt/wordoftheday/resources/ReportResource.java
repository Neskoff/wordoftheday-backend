package com.rbt.wordoftheday.resources;

import com.rbt.wordoftheday.domain.Campaign;
import com.rbt.wordoftheday.domain.Report;
import com.rbt.wordoftheday.services.campaignService.CampaignService;
import com.rbt.wordoftheday.services.reportService.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportResource {
    @Autowired
    private ReportService reportService;
    @Autowired
    private CampaignService campaignService;
;

    @GetMapping("/current")
    public ResponseEntity<Report> currentCampaignReport() {
        Campaign activeCampaign = this.campaignService.getCurrentCampaign();
        return ResponseEntity.ok(this.reportService.getCampaignReport(activeCampaign.getId()));
    }

    @PutMapping
    public ResponseEntity<Boolean> updateReport(@RequestBody Report report) {
        return ResponseEntity.ok((this.reportService.updateCampaignReport(report)));
    }
}
