package com.allen.compont;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author tanla
 * @version 1.0
 * @description todo
 * @date 2021/3/21 21:08
 **/
@Component
public class ScheduleTask {

    private static final Logger log= LoggerFactory.getLogger(ScheduleTask.class);

    //@Scheduled(cron = "*/1 * * * * ?")
    @Scheduled(fixedRate = 1000)
    // @Async
    public void schedulePrintHello(){
        log.info("hello allen-----");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //@Scheduled(fixedDelay = 1000*5)
    public void schedulePrintGoodBye(){
        log.info("good bye allen----");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
