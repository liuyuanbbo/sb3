package org.zmz.sb3.newfeatures.test.boot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zmz.sb3.newfeatures.boot.Bean1;

@SpringBootTest
@Slf4j
public class Bean1Boot {

    @Autowired
    Bean1 bean1;

    @Test
    public void t1() {
        String s = bean1.sayHello();
        log.info("{}", s);
    }

}
