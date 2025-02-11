package io.jcz.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String sql = null;

        System.out.println(isDynamicSql(sql));
    }

    public static boolean isDynamicSql(String sql) {
        // 检查字符串中是否包含{},且不包括${},其中 {} 中可以包含任意字符
        Pattern pattern = Pattern.compile("\\{(?!(\\$\\{.*}))[^\\{\\}]*\\}");
        Matcher matcher = pattern.matcher(sql);
        return matcher.find();
    }
}
