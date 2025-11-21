package zzjjcc.controller.mariadb.mytest;

import cn.hutool.core.lang.TypeReference;
import cn.hutool.core.map.MapUtil;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.column.SimpleColumnWidthStyleStrategy;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/easyExcel")
public class EasyExcelController {

    public static final Logger LOG = LoggerFactory.getLogger(EasyExcelController.class);

    @Autowired
    HttpServletResponse response;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("/modelDynamicExportExcel1")
    public void modelDynamicExportExcel1(@RequestBody Map<String, Object> params) {
        String json;
        try {
            json = objectMapper.writeValueAsString(params);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        LOG.info("{}", json);
    }

    /**
     * 根据前端传参动态导出 Excel 数据
     */
    @PostMapping(value = "/modelDynamicExportExcel")
    public void modelDynamicExportExcel(@RequestBody Map<String, Object> params) {
        // 1. 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = System.currentTimeMillis() + ".xlsx";
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName);

        // 2. 动态生成数据
        String sheetName = MapUtil.getStr(params, "sheetName", "sheet0");
        List<Map<String, Object>> datas = MapUtil.get(params, "datas", new TypeReference<>() {
        });

        // 模拟数据
        /*
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> row1 = new HashMap<>();
        row1.put("name", "张三");
        row1.put("age", 25);
        row1.put("email", "zhangsan@example.com");
        dataList.add(row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("name", "李四");
        row2.put("age", 30);
        row2.put("email", "lisi@example.com");
        dataList.add(row2);

        datas = dataList;
         */

        if (CollectionUtils.isNotEmpty(datas)) {
            // 3. 直接写入响应输出流
            try (ExcelWriter writer = EasyExcel.write(response.getOutputStream()).build()) {
                List<String> headers = new ArrayList<>(datas.getFirst().keySet());
                List<List<Object>> vals = convertVals(datas, headers);
                WriteSheet sheet = EasyExcel.writerSheet(sheetName)
                        .registerWriteHandler(new SimpleColumnWidthStyleStrategy(22))
                        .head(convertHead(headers)).build();
                writer.write(vals, sheet);
            } catch (IOException e) {
                throw new RuntimeException("modelDynamicExportExcel IOException");
            }
        }

    }

    private List<List<Object>> convertVals(List<Map<String, Object>> datas, List<String> headers) {
        // 动态设置数据
        List<List<Object>> list = new ArrayList<>();
        for (Map<String, Object> map : datas) {
            List<Object> row = new ArrayList<>();
            for (String header : headers) {
                row.add(map.get(header));
            }
            list.add(row);
        }
        return list;
    }

    /**
     * 将 List<String> 转换为 EasyExcel 所需的 Head 格式
     */
    private static List<List<String>> convertHead(List<String> head) {
        List<List<String>> result = new ArrayList<>();
        for (String column : head) {
            result.add(Collections.singletonList(column));
        }
        return result;
    }

    @GetMapping("/excel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        // 模拟数据
        List<Map<String, Object>> dataList = new ArrayList<>();
        Map<String, Object> row1 = new HashMap<>();
        row1.put("name", "张三");
        row1.put("age", 25);
        row1.put("email", "zhangsan@example.com");
        dataList.add(row1);

        Map<String, Object> row2 = new HashMap<>();
        row2.put("name", "李四");
        row2.put("age", 30);
        row2.put("email", "lisi@example.com");
        dataList.add(row2);

        // 设置响应头
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户数据", "UTF-8");
        response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xlsx");

        // 获取输出流
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();

        // 动态生成表头
        if (!dataList.isEmpty()) {
            Map<String, Object> firstRow = dataList.get(0);
            List<List<String>> head = new ArrayList<>();
            for (String key : firstRow.keySet()) {
                List<String> headColumn = new ArrayList<>();
                headColumn.add(key);
                head.add(headColumn);
            }

            // 写入数据
            WriteSheet writeSheet = EasyExcel.writerSheet("Sheet1").head(head).build();
            excelWriter.write(dataList, writeSheet);
        }

        // 关闭流
        excelWriter.finish();
    }

}
