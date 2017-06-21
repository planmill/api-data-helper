package com.planmill.api.datahelper.test;

import com.planmill.api.datahelper.model.TimeReport;
import com.planmill.api.datahelper.service.TimeReportService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeReports {

    @Autowired
    private TimeReportService timeReportService;

    /**
     * Return list of time reports for current api user.
     */
    @Test
    public void getList() {
        List<TimeReport> list = timeReportService.getList();
        if (!list.isEmpty()) {
            list.forEach(item -> log.info("timereport: {} / {}", item.getId(), item.getComment()));
        } else {
            log.info("no time reports available");
        }
    }
}
