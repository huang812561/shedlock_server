package com.schedlock.task;

import net.javacrumbs.shedlock.core.SchedulerLock;
import net.javacrumbs.shedlock.spring.annotation.EnableSchedulerLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName com.schedlock.task.ScheduledTask
 * @Description: TODO
 * @User: hgq
 * @Date: 2020-07-07 10:23
 * @Version: 1.0
 */
@Component
public class ScheduledTask {
    private final Logger logger = LoggerFactory.getLogger(SchedulerLock.class);

    private static final int TWENTY_NINE_MIN = 1000;
//    private static final int TWENTY_NINE_MIN = 60 * 1000;
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");


    /**
     * lockAtMostFor & lockAtMostForString：指定在执行节点死亡时应将锁保留多长时间，在正常情况下，任务完成后立即释放锁定。 您必须将其设置lockAtMostFor为比正常执行时间长得多的值
     * lockAtLeastFor & lockAtLeastForString ：该属性指定应保留锁定的最短时间
     * 假设您有一个任务希望每15分钟最多执行一次，每15分钟执行一次，且每次执行需要花费5分钟，
     * 该锁将持有5分钟，当节点异常或者死亡，该锁默认在15分钟后自动释放。
     */
    @SchedulerLock(name = "task1",lockAtMostFor = TWENTY_NINE_MIN, lockAtLeastFor = TWENTY_NINE_MIN)
    @Scheduled(cron = "10/* * * * * ?")
    public void task1(){
        logger.info("begin refreshHotSumAndIsOnTop...");
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("时间："+ sdf.format(new Date())+" task1执行");
        logger.info("begin refreshHotSumAndIsOnTop...");
    }
}
