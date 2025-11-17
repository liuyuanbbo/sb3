package org.zmz.sb3.newfeatures.test.regex;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class MyTester_1 {

    @Test
    public void t0() {

    }

    @Test
    public void t1() {
        String sql = """
                select
                  '200' as consume_org_id,
                  '-1.200.' as consume_path_code,
                  tb1.city_name_new as city_name_new,
                  COUNT(
                    CASE
                      WHEN (
                        (
                          case
                            when { date_flag } = '派单时间' then create_date
                            else finish_date
                          end between parseDateTimeBestEffort({ create_date_start })
                          and parseDateTimeBestEffort({ create_date_end }) + 24 * 3600 - 1
                          and case
                            when { re_type } = 'F单' then is_f_order
                            when { re_type } = 'S单' then is_s_order
                            when { re_type } = '协办单' then is_assist_order
                            when { re_type } = 'S单+协办单' then is_s_assist_order
                            else '1'
                          end = '1'
                        )
                      ) THEN tb1.order_id
                      ELSE null
                    END
                  ) as order_id_count,
                  SUM(
                    CASE
                      WHEN (
                        (
                          tb1.is_fttr = '是'
                          and tb1.order_state = '10F'
                          and tb1.is_recalledorder = '0'
                          and finish_date >= toStartOfMonth(parseDateTimeBestEffort({ create_date }))
                          and finish_date <= parseDateTimeBestEffort({ create_date }) + 24 * 3600 - 1
                        )
                      ) THEN tb1.clsc
                      ELSE 0
                    END
                  ) as clsc_sum
                from
                  dwm.dwm_hw_re_complaint_order_wide_label_r tb1
                  inner join dim.dim_uos_area tb2 on tb1.county_id = tb2.county_id
                where
                  tb2.path_code like '%-1.200.%'
                group by
                  tb1.city_name_new
                """;
        List<String> sqlColumnList = getSqlColumnList(sql);
        log.info("<<< buildGroupQueryFields getSqlColumnList >>> {}", sqlColumnList);
    }

    @Test
    public void t2() {
        String primaryKey = "1212,5656,89466";
        String cleanedPrimaryKey = primaryKey.replaceAll("[\\[\\]\\s]", "");
        List<Long> primaryKeys = Arrays.stream(cleanedPrimaryKey.split(",")).filter(StringUtils::isNotEmpty)
                .map(String::trim).map(Long::valueOf).toList();
        for (Long key : primaryKeys) {
            log.info("{}", key);
        }
    }

    public static List<String> getSqlColumnList(String sql) {

        if (StringUtils.isEmpty(sql)) {
            return Collections.emptyList();
        }

        // 检查字符串中是否包含{},且不包括${},其中 {} 中可以包含任意字符
        List<String> resultListDyn = new ArrayList<>(10);
        List<String> resultListVal = new ArrayList<>(10);

        // 获取{xxx}的动态参数，过滤掉${xxx}的
        Pattern patternDyn = Pattern.compile("\\{([^{}]+)\\}");
        Pattern patternVal = Pattern.compile("\\$\\{([^{}]+)\\}");
        Matcher matcher = patternDyn.matcher(sql);
        while (matcher.find()) {
            resultListDyn.add(matcher.group(1).trim());
        }
        matcher = patternVal.matcher(sql);
        while (matcher.find()) {
            resultListVal.add(matcher.group(1).trim());
        }
        resultListDyn.removeAll(resultListVal);
        return resultListDyn;
    }
}
