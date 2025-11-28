package org.zmz.sb3.newfeatures.j21.str;

import com.alibaba.fastjson.JSONObject;

import java.util.Map;

public class STR1 {
    void main() {
        String s = """
                {
                "componentId":"1644",
                "pageIndex":1,"pageSize":10,
                "type":"SCHEMA",
                "syncType":"HIVE_SCHEMA",
                "language":"zh-CN",
                "envType":"shanghaidianxin"
                }
                """;
        Map<?, ?> parseMap = JSONObject.parseObject(s, Map.class);
        System.out.println(parseMap);
    }
}
