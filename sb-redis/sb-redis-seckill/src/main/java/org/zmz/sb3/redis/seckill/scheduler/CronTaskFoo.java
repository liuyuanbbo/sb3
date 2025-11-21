package org.zmz.sb3.redis.seckill.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.security.SecureRandom;
import java.util.Random;

//@Service
public class CronTaskFoo implements IPollableService {

    public static final Logger LOG = LoggerFactory.getLogger(CronTaskFoo.class);

    private static final Random random = new SecureRandom();

    @Override
    public void poll() {
        LOG.info("Say Foo");
    }

    @Override
    public String getCronExpression() {
        return "0/" + (random.nextInt(9) + 1) + " * * * * ?";
    }
}