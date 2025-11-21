package org.zmz.sb3.redis.seckill.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zmz.sb3.redis.seckill.domain.Item;
import org.zmz.sb3.redis.seckill.domain.ItemStock;
import org.zmz.sb3.redis.seckill.mapper.ItemMapper;

@Service
public class ItemService extends ServiceImpl<ItemMapper, Item> {
    @Autowired
    private ItemStockService itemStockService;

    @Transactional
    public void saveItem(Item item) {
        // 新增商品
        this.save(item);
        // 新增库存
        ItemStock stock = new ItemStock();
        stock.setId(item.getId());
        stock.setStock(item.getStock());
        itemStockService.save(stock);
    }
}
