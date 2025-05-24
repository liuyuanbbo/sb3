package org.zmz.sb3.newfeatures.test.num;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestNum01 {
    @Test
    public void t1() {
        System.out.println(Long.parseLong(null));
    }

    @Test
    public void t2() {
        List<Long> lst1 = List.of(1L, 2L, 3L);
        List<Long> lst2 = List.of(2L, 3L);

        Collection<Long> subtractCols = CollectionUtils.subtract(lst1, lst2);

        System.out.println(subtractCols.size());
        System.out.println(subtractCols);
    }

    @Test
    public void t3() {
        List<Long> lst1 = List.of(19205L, 19115L, 19115L, 19115L, 19115L, 19115L);
        Set<Long> lst2 = Set.of(19115L);

        Collection<Long> subCol = CollectionUtils.subtract(lst1, lst2);
        Set<Long> setSubCol = new HashSet<>(subCol);
        System.out.println(setSubCol);
        System.out.println(setSubCol.size());
    }
}
