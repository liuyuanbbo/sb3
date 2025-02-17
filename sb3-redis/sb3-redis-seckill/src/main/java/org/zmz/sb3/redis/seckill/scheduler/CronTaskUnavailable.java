package org.zmz.sb3.redis.seckill.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

//@Service
public class CronTaskUnavailable implements IPollableService {

    public static final Logger LOG = LoggerFactory.getLogger(CronTaskUnavailable.class);

    private String cronExpression = "-";
    private static final Map<String, String> map = new HashMap<>();

    static {
        map.put("-", "0/1 * * * * ?");
        map.put("0/1 * * * * ?", "-");
    }

    @Override
    public void poll() {
        LOG.info("Say Unavailable");
    }

    @Override
    public String getCronExpression() {
        return (cronExpression = map.get(cronExpression));
    }
}