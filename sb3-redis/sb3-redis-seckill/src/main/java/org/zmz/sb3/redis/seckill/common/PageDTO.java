package org.zmz.sb3.redis.seckill.common;

import lombok.Data;
import org.zmz.sb3.redis.seckill.domain.Item;

import java.util.List;

@Data
public class PageDTO {
    private Long total;
    private List<Item> list;

    public PageDTO() {
    }

    public PageDTO(Long total, List<Item> list) {
        this.total = total;
        this.list = list;
    }
}
