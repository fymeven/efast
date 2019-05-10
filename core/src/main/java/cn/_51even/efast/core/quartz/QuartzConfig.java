//package cn._51even.efast.core.quartz;
//
//import org.quartz.Scheduler;
//import org.quartz.spi.TriggerFiredBundle;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.quartz.AdaptableJobFactory;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//
//@Configuration
//public class QuartzConfig {
//
//    @Autowired
//    private AutowireCapableBeanFactory autowireCapableBeanFactory;
//
////    public Properties quartzConfig(){
////        Properties properties = new Properties();
////        return properties;
////    }
//
//    @Bean
//    public SchedulerFactoryBean schedulerFactoryBean(){
//        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
//        schedulerFactoryBean.setOverwriteExistingJobs(true);
////        schedulerFactoryBean.setQuartzProperties(quartzConfig());
//        AdaptableJobFactory jobFactory = new AdaptableJobFactory() {
//            @Override
//            protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception {
//                Object jobInstance = super.createJobInstance(bundle);
//                autowireCapableBeanFactory.autowireBean(jobInstance);
//                return jobInstance;
//            }
//        };
//        schedulerFactoryBean.setJobFactory(jobFactory);
//        return schedulerFactoryBean;
//    }
//
//    @Bean(name = "scheduler")
//    public Scheduler scheduler(){
//        return schedulerFactoryBean().getScheduler();
//    }
//}
