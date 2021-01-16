package com.kou.quartzMain;

import com.kou.quartzJob.HelloJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author JIAJUN KOU
 */
public class HelloMain {
    public static void main(String[] args) throws SchedulerException {
        //1、调度器
        Scheduler defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
        //2任务实例
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("job1", "group1")
                .build();

        //3触发器
        SimpleTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatSecondlyForever(5).withRepeatCount(3))
                .build();

        System.out.println(jobDetail.getKey().getName());
        System.out.println("任务类"+jobDetail.getJobClass().getName());
        //让调度器关联任务和触发器，保证按照触发器的要求来
        defaultScheduler.scheduleJob(jobDetail,trigger);

        //启动
        defaultScheduler.start();


    }
}
