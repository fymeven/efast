//package cn._51even.efast.core.quartz;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.util.Date;
//import java.util.Map;
//
///**
// * Created by _51even on 2017/11/10.
// */
//
//@Component
//public class QuartzUtil {
//
//    private static final Logger logger = LoggerFactory.getLogger(QuartzUtil.class);
//
//    private static String DEFAULT_GROUP_NAME = "DEFAULT_QUARTZ_GROUP"; //触发器组
//
//    private static Scheduler scheduler;
//
//    @Resource
//    public void setScheduler(Scheduler scheduler) {
//        QuartzUtil.scheduler = scheduler;
//    }
//
//    public static boolean addSimpleJob(String jobName, String jobDescription, Date startTime, Class<? extends Job> jobClass, Integer interval, Integer repeatCount, Map jobDataMap) {
//        try {
//            JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
//            jobBuilder.withIdentity(jobName,DEFAULT_GROUP_NAME);
//            jobBuilder.withDescription(jobDescription);
//            JobDetail jobDetail = jobBuilder.build();
//            if (jobDataMap !=null){
//                jobDetail.getJobDataMap().putAll(jobDataMap);
//            }
//            //创建scheduler调度器
//            SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule();
//            scheduleBuilder.withIntervalInSeconds(interval);
//            if (repeatCount == null){
//                scheduleBuilder.repeatForever();//重复次数为空则一直执行
//            }else{
//                scheduleBuilder.withRepeatCount(repeatCount);
//            }
//            //创建trigger触发器
//            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
//            triggerBuilder.withIdentity(jobName,DEFAULT_GROUP_NAME);
//            triggerBuilder.startAt(startTime);
//            triggerBuilder.withSchedule(scheduleBuilder);
//            //创建Trigger对象
//            SimpleTrigger trigger = (SimpleTrigger) triggerBuilder.build();
//            //开始调度任务
//            scheduler.scheduleJob(jobDetail, trigger);
//            if (!scheduler.isShutdown()) {
//                scheduler.start();
//            }
//            return true;
//        } catch (SchedulerException e) {
//            logger.error("创建simple任务失败,cause:{}",e);
//            return false;
//        }
//    }
//
//    public static boolean addcCronJob(String jobName, String jobDescription, Class<? extends Job> jobClass, String cron, Map jobDataMap) {
//        try {
//            JobBuilder jobBuilder = JobBuilder.newJob(jobClass);
//            jobBuilder.withIdentity(jobName,DEFAULT_GROUP_NAME);
//            jobBuilder.withDescription(jobDescription);
//            JobDetail jobDetail = jobBuilder.build();
//            if (jobDataMap !=null){
//                jobDetail.getJobDataMap().putAll(jobDataMap);
//            }
//            //创建scheduler调度器
//            CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
//            //创建trigger触发器
//            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
//            triggerBuilder.withIdentity(jobName, DEFAULT_GROUP_NAME);
//            triggerBuilder.startNow();
//            triggerBuilder.withSchedule(cronScheduleBuilder);
//            //创建Trigger对象
//            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
//            //调度容器设置JobDetail和Trigger
//            scheduler.scheduleJob(jobDetail, trigger);
//            //启动
//            if (!scheduler.isShutdown()) {
//                scheduler.start();
//            }
//            return true;
//        } catch (SchedulerException e) {
//            logger.error("创建cron任务失败,cause:{}",e);
//            return false;
//        }
//    }
//
////    public static void updateJobTime(String jobName, String jobGroup,Date newStartTime) {
////        try {
////            Scheduler scheduler = schedulerFactory.getScheduler();
////            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);      //通过触发器名和组名获取TriggerKey
////            Trigger trigger = scheduler.getTrigger(triggerKey);//通过TriggerKey获取CronTrigger
////            if (trigger == null) {
////                return;
////            }
////            Date oldStartTime = trigger.getStartTime();
////                JobKey jobKey = JobKey.jobKey(jobName, jobGroup);                     //通过任务名和组名获取JobKey
////                JobDetail jobDetail = scheduler.getJobDetail(jobKey);
////                Class<? extends Job> jobClass = jobDetail.getJobClass();
////                removeJob(jobName);
////                addJob(jobName,jobGroup,newStartTime,jobClass);
////        } catch (Exception e) {
////            throw  new Exception("创建修改失败");
////        }
////    }
//
//
//    public static void removeJob(String jobName,String jobGroup) {
//        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
//            TriggerKey triggerKey = TriggerKey.triggerKey(jobName,jobGroup);    //通过触发器名和组名获取TriggerKey
//            JobKey jobKey = JobKey.jobKey(jobName, jobGroup);                           //通过任务名和组名获取JobKey
//            scheduler.pauseTrigger(triggerKey); // 停止触发器
//            scheduler.unscheduleJob(triggerKey);// 移除触发器
//            scheduler.deleteJob(jobKey);        // 删除任务
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 启动所有定时任务
//     */
//    public static void startJobs() {
//        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
//            scheduler.start();
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    /**
//     * 关闭所有定时任务
//     */
//    public static void shutdownJobs() {
//        try {
//            Scheduler scheduler = schedulerFactory.getScheduler();
//            if (!scheduler.isShutdown()) {
//                scheduler.shutdown();
//            }
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//}
