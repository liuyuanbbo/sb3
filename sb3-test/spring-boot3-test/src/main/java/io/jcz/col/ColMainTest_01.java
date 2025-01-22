package io.jcz.col;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ColMainTest_01 {
    public static void main(String[] args) {
        List<Cls> clsList = List.of(
                new Cls(1L, "zjc1", "zjc1"),
                new Cls(1L, "zjc1-1", "zjc1-1"),
                new Cls(2L, "zjc2", "zjc2"),
                new Cls(2L, "zjc2-1", "zjc2-1"),
                new Cls(2L, "zjc2-2", "zjc2-2"),
                new Cls(3L, "zjc3", "zjc3")
        );

        List<Cls> rs = new ArrayList<>();

        Map<Long, List<Cls>> map = clsList.stream().collect(Collectors.groupingBy(Cls::getId));

        for (Map.Entry<Long, List<Cls>> entry : map.entrySet()) {
            List<Cls> clss = entry.getValue();
            String names = clss.stream().map(Cls::getName).collect(Collectors.joining(","));
            Cls cls0 = clss.getFirst();
            cls0.setName(names);
            rs.add(cls0);
        }

        System.out.println(rs);

        System.out.println("==================================================");
        List<Cls> cls = new ArrayList<>();

        cls.add(new Cls(1L, "zjc1", "zjc1"));

        Cls cls1 = cls.getFirst();
        if ("zjc1".equals(cls1.getCode())) {
            Cls clsCp = new Cls();
            BeanUtils.copyProperties(cls1, clsCp);
            clsCp.setCode("zjc1-CP");

            cls.add(clsCp);
        }

        System.out.println(cls);
        System.out.println("==================================================");
        List<Integer> lst1 = List.of(1, 2, 3);
        List<Integer> lst2 = List.of(2, 3);
        Collection<Integer> intersectionCol = CollectionUtils.subtract(lst1, lst2);
        System.out.println(intersectionCol);
        System.out.println("==================================================");
    }

    static class Cls {
        Long id;
        String code;
        String name;

        public Cls() {
        }

        public Cls(Long id, String code, String name) {
            this.id = id;
            this.code = code;
            this.name = name;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Cls{" +
                    "id=" + id +
                    ", code='" + code + '\'' +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
