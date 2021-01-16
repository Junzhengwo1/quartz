package com.kou.quartzJob;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author JIAJUN KOU
 *
 *
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        //输出当前时间的任务
        Date date =new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(date);

        System.out.println("执行的时间是："+format );
        System.out.println(context.getFireTime());

    }
}
