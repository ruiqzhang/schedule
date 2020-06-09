package com.github.schedule.task;

import com.github.schedule.service.DemoService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import javax.annotation.Resource;

/**
 *
 * @author zrq
 * @date
 */
@Configuration
public class DynamicScheduleTask implements SchedulingConfigurer {

    @Resource
    private DemoService demoService;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        scheduledTaskRegistrar.addCronTask(new CronTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("动态任务执行");

                demoService.execute();
            }
        }, "0/5 * * * * ?"));
    }

}
