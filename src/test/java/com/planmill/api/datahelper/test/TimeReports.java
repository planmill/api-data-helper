package com.planmill.api.datahelper.test;

import com.planmill.api.datahelper.DefaultPmFormats;
import com.planmill.api.datahelper.model.TimeReport;
import com.planmill.api.datahelper.service.TimeReportService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Created by konstantin.petrukhnov@planmill.com on 2017-06-15.
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeReports {

    private static final int DEFAULT_USER_ID = 356;

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

    /**
     * Create basic timereport (minimal data)
     */
    @Test
    public void createSomeTimeReports() {

        ZonedDateTime startTime = ZonedDateTime.now().minusHours(4).withMinute(0);
        ZonedDateTime endTime = ZonedDateTime.now().minusHours(1).withMinute(0);

        TimeReport tr = new TimeReport();

        log.debug("starttime: {}", startTime.format(DefaultPmFormats.getDateTimeFormatter()));

        tr.setStart(startTime.format(DefaultPmFormats.getDateTimeFormatter()));
        tr.setFinish(endTime.format(DefaultPmFormats.getDateTimeFormatter()));
        tr.setAmount(((int) Duration.between(endTime, startTime).toMinutes())); //in minutes
        tr.setPerson(DEFAULT_USER_ID); //id of person

        timeReportService.addTimeReport(tr);
    }

    /**
     * Create multiple timereports
     */
    @Test
    public void createTimeReportsForMonths() {

        for (int i = 0; i < 50; i++) {

            ZonedDateTime startTime = ZonedDateTime.now().minusDays(i*3).minusHours(2).withMinute(30);
            ZonedDateTime endTime = ZonedDateTime.now().minusDays(i*3).minusHours(1).withMinute(30);

            TimeReport tr = new TimeReport();
            tr.setStart(startTime.format(DefaultPmFormats.getDateTimeFormatter()));
            tr.setFinish(endTime.format(DefaultPmFormats.getDateTimeFormatter()));
            tr.setAmount(((int) Duration.between(endTime, startTime).toMinutes()));
            tr.setPerson(DEFAULT_USER_ID);
            tr.setComment("coffee time");

            timeReportService.addTimeReport(tr);
        }
    }
}
