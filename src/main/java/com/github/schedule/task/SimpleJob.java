package com.github.schedule.task;

import com.github.schedule.service.DemoService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author zrq
 * @date
 */
@Component
public class SimpleJob {

    @Resource
    private DemoService demoService;

    @Scheduled(cron = "0/10 * * * * ?")
    public void hello() {
        System.out.println("简单任务");

        demoService.execute();
    }

}
