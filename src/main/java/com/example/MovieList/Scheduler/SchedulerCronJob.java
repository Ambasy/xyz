package com.example.MovieList.Scheduler;

import com.example.MovieList.Service.FileDataService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling
public class SchedulerCronJob {
    private static final Logger LOGGER = LogManager.getLogger(SchedulerCronJob.class);
    @Autowired
    private FileDataService fileDataService;

    // Scheduled for Every Minute
    @Scheduled(cron = "1 * * * * *")
    public void syncDataUpdates() throws Exception {
        LOGGER.info("Updating Data in Database");
        fileDataService.saveData();
    }
}
