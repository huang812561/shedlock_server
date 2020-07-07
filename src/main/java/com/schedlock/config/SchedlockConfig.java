package com.schedlock.config;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;
import net.javacrumbs.shedlock.provider.redis.spring.RedisLockProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;

import javax.sql.DataSource;

/**
 * @ClassName com.schedlock.config.SchedlockConfig
 * @Description: Spring ShedLock 确保我们的计划任务只能同时运行一次
 * @User: hgq
 * @Date: 2020-07-07 10:07
 * @Version: 1.0
 */
@Configuration
public class SchedlockConfig {

    /**
     * 配置jdbc协调任务
     * @param dataSource
     * @return
     */
    @Bean
    public LockProvider lockProvider(DataSource dataSource){
        return new JdbcTemplateLockProvider(dataSource);
    }

    /**
     * 配置redis协调任务
     * @param redisConnectionFactory
     * @return
     */
/*    @Bean
    public LockProvider lockProvider(RedisConnectionFactory redisConnectionFactory){
        return new RedisLockProvider(redisConnectionFactory);
    }*/

}
