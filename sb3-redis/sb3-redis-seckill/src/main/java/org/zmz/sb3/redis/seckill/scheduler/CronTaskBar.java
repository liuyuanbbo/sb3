package org.zmz.sb3.redis.seckill.scheduler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class CronTaskBar implements IPollableService {

    @Autowired
    StringRedisTemplate stringRedisTemplate;

    public static final Logger LOG = LoggerFactory.getLogger(CronTaskBar.class);

    @Async
    @Override
    public void poll() {
        try {
            TimeUnit.HOURS.sleep(1);
        } catch (InterruptedException e) {
            LOG.info("<<< execute task error >>>", e);
        }
        LOG.info(">>> Say Bar >>> ");
    }

    @Override
    public String getCronExpression() {
        //return "0/5 * * * * ?";
        String cronExp = stringRedisTemplate.opsForValue().get("CronTaskBar");
        LOG.info("CronExp get from redis: {}", cronExp);
        return StringUtils.isBlank(cronExp) ? "0/5 * * * * ?" : cronExp;
    }
}