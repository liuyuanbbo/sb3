package io.jcz.col;

import org.apache.commons.collections4.CollectionUtils;

import java.util.Collection;
import java.util.List;

public class ColMainTest_02 {
    public static void main(String[] args) {
        // 已经存在管理的目录id集合
        List<Long> lst1 = List.of(101L, 102L, 103L);

        // 前端传过来的目录id集合
        List<Long> lst = List.of(101L);

        // 待 新增的集合
        Collection<Long> col1 = CollectionUtils.subtract(lst, lst1);
        System.out.println(col1);

        // 待 删除的集合
        Collection<Long> col2 = CollectionUtils.subtract(lst1, lst);
        System.out.println(col2);

    }

}
