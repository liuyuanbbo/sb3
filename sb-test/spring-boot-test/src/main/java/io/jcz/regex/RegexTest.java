package io.jcz.regex;

import java.time.Instant;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String sql = null;
        long epochMilli = Instant.now().toEpochMilli();
        long i = 1743070387748L - 1743070278374L;
        // 1800000
        System.out.println(i);
        System.out.println(epochMilli);
        System.out.println(isDynamicSql(sql));
    }

    public static boolean isDynamicSql(String sql) {
        // 检查字符串中是否包含{},且不包括${},其中 {} 中可以包含任意字符
        Pattern pattern = Pattern.compile("\\{(?!(\\$\\{.*}))[^\\{\\}]*\\}");
        Matcher matcher = pattern.matcher(sql);

        return matcher.find();
    }
}
