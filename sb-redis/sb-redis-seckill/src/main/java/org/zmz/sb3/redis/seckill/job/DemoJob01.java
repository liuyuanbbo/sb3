package org.zmz.sb3.redis.seckill.job;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class DemoJob01 {

    public static final Logger LOG = LoggerFactory.getLogger(DemoJob01.class);

    //@Scheduled(cron = "0/5 * * * * ?")
    public void schedule01() {
        LOG.info("定时任务执行成功 --> {}", System.currentTimeMillis());
    }

}
