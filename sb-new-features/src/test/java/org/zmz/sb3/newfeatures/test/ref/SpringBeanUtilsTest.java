package org.zmz.sb3.newfeatures.test.ref;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;

@Slf4j
public class SpringBeanUtilsTest {

    @Getter
    @Setter
    @ToString
    static class A {
        private Long id;
        private B b;
    }

    @Getter
    @Setter
    @ToString
    static class B {
        private String bar;
        private C c;
    }

    @Getter
    @Setter
    @ToString
    static class C {
        private String foo;
    }

    @Test
    public void t1() {
        C c = new C();
        c.setFoo("foo--c");

        B b = new B();
        b.setBar("bar--b");
        b.setC(c);

        A a = new A();
        a.setId(1L);
        a.setB(b);

        log.info("copy before:{}", ReflectionToStringBuilder.toString(a, ToStringStyle.MULTI_LINE_STYLE));

        A copyA = new A();

        BeanUtils.copyProperties(a, copyA);

        log.info("copyA before:{}", ReflectionToStringBuilder.toString(a, ToStringStyle.MULTI_LINE_STYLE));

        copyA.setId(11L);

        C copyC = new C();
        copyC.setFoo("foo--copyC");

        B copyB = new B();
        copyB.setBar("bar--copyB");
        copyB.setC(copyC);

        copyA.setB(copyB);

        log.info("copy after:{}", ReflectionToStringBuilder.toString(a, ToStringStyle.MULTI_LINE_STYLE));
        log.info("copyA :{}", ReflectionToStringBuilder.toString(copyA, ToStringStyle.MULTI_LINE_STYLE));
    }
}
