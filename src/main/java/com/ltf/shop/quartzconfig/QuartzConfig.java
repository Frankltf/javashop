package com.ltf.shop.quartzconfig;

import com.ltf.shop.quartzdemo.HelloJob;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@Configuration
public class QuartzConfig {
    /**
     * 创建Job对象
     */
    @Bean
    public JobDetailFactoryBean jobDetailFactoryBean()
    {
        JobDetailFactoryBean factory=new JobDetailFactoryBean();
        factory.setJobClass(HelloJob.class);
        return  factory;
    }

    /**
     * 创建Job对象
     */
//    @Bean
//    public SimpleTriggerFactoryBean simpleTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean)
//    {
//        SimpleTriggerFactoryBean simpleTriggerFactoryBean=new SimpleTriggerFactoryBean();
//        //关联JobDetail对象
//        simpleTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
//        //设置执行的毫秒数
//        simpleTriggerFactoryBean.setRepeatInterval(3000);
//        simpleTriggerFactoryBean.setRepeatCount(15);
//        return simpleTriggerFactoryBean;
//    }

//    /**
//     * 创建scheduler对象
//     */
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(SimpleTriggerFactoryBean simpleTriggerFactoryBean)
//    {
//        SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
//        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean.getObject());
//        return schedulerFactoryBean;
//    }


    @Bean
    public CronTriggerFactoryBean cronTriggerFactoryBean(JobDetailFactoryBean jobDetailFactoryBean)
    {
        CronTriggerFactoryBean cronTriggerFactoryBean=new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(jobDetailFactoryBean.getObject());
        cronTriggerFactoryBean.setCronExpression("0/2 * * * * ?");
        return cronTriggerFactoryBean;
    }

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(CronTriggerFactoryBean cronTriggerFactoryBean)
    {
        SchedulerFactoryBean schedulerFactoryBean=new SchedulerFactoryBean();
        schedulerFactoryBean.setTriggers(cronTriggerFactoryBean.getObject());
        return schedulerFactoryBean;
    }
}
