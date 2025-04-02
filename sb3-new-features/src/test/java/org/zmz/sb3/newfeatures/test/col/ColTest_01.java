package org.zmz.sb3.newfeatures.test.col;

import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.zmz.sb3.newfeatures.col.FastListUtil;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ColTest_01 {
    @Test
    public void t1() {
        List<Map<String, Object>> list = List.of(
                Map.of("k1", List.of("1", "2")),
                Map.of("k2", new Object()),
                Map.of("k3", 1),
                Map.of("k4", new Person("zjc", 26))
        );

        if (FastListUtil.isNotEmpty(list)) {
            for (Map<String, Object> map : list) {
                FastListUtil.getValue(map, "k1", List.class);
            }
        }
    }

    record Person(String name, Integer age) {

    }

    @Test
    public void t2() {
        //String path = "1.2.3";
        //String path="1";
        String path = "1.2";
        String[] items = StringUtils.split(path, '.');
        System.out.println(Arrays.toString(items));
    }

    @Test
    public void t3() {
        String path = "1.2";
        List<String> items = StrUtil.split(path, ".");
        String item0 = items.get(0);
        List<String> subItems = items.subList(1, items.size() - 1);
        System.out.println(item0);
        System.out.println(subItems);
    }

    @Test
    public void t4() {
        Map<Long, CallTrendVo> map = initCallTrendVo(6);
        map.forEach((k, v) -> System.out.println(k + "-->" + v.getCpcpTotal() + "-->" + v.getCnsTotal() + "-->" + v.getCsTotal()));
        List<CallTrendVo> vos = new ArrayList<>(map.values());

        vos.sort(Comparator.comparingLong(CallTrendVo::getMonth).reversed());
        System.out.println(vos);
    }

    @Test
    public void t5() {
        //String dirFullPath = "-1.10.100.1000";
        String dirFullPath = "-1.10";
        //String dirFullPath = "-1";
        String s = StringUtils.substringBeforeLast(dirFullPath, ".");
        String[] items = s.split("\\.");
        System.out.println(s);
        System.out.println(items.length);
    }

    @Test
    public void t6() {
        List<String> list = new ArrayList<>();
        list.add("-1");

        String remove = list.remove(0);

        System.out.println(remove);
        System.out.println(list);
    }

    @Test
    public void t7() {
        Map<String, Object> map = new LinkedHashMap<>();
        int i = Runtime.getRuntime().availableProcessors() << 2;
        System.out.println(i);
    }

    @Test
    public void t8() {
        String s = "用户:tele_v7 处理了低频标签:zjc001，账期为202503，当前标签CPCP近6月调用次数为2，API近6月调用次数为1，行云近6月调用次数为3，处理类型：冻结,处理描述:xxxx";

        String ss = StringUtils.substringAfterLast(s, ":");
        System.out.println(ss);
    }

    @Test
    public void t9() {
        System.out.println(Integer.MAX_VALUE);
    }

    public Map<Long, CallTrendVo> initCallTrendVo(int recent) {
        Map<Long, CallTrendVo> map = new LinkedHashMap<>();
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
        for (int i = 1; i <= recent; i++) {
            LocalDate localDate = now.minusMonths(i);
            String formatDate = formatter.format(localDate);
            long key = Long.parseLong(formatDate.substring(0, 6));
            CallTrendVo vo = new CallTrendVo(0L, 0L, 0L);
            vo.setMonth(key);
            map.put(key, vo);
        }
        return map;
    }

    @Getter
    @Setter
    @ToString
    public static class CallTrendVo {
        // 格式 yyyyMM
        private Long month;

        // cpcp 调用次数
        private Long cpcpTotal;

        // API 调用次数
        private Long cnsTotal;

        // 行云 调用次数
        private Long csTotal;

        public CallTrendVo() {
        }

        public CallTrendVo(Long cpcpTotal, Long cnsTotal, Long csTotal) {
            this.cpcpTotal = cpcpTotal;
            this.cnsTotal = cnsTotal;
            this.csTotal = csTotal;
        }
    }
}
