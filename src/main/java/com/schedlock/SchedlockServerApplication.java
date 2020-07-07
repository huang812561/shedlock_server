package com.schedlock;

import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

//开启定时任务注解
@EnableScheduling
//开启定时任务锁，默认设置锁最大占用时间为30s
@EnableSchedulerLock(defaultLockAtMostFor = "PT30S")
@SpringBootApplication
public class SchedlockServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedlockServerApplication.class, args);
    }

}
