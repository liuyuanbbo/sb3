package org.zmz.sb3.redis.seckill.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.zmz.sb3.redis.seckill.common.PageDTO;
import org.zmz.sb3.redis.seckill.domain.Item;
import org.zmz.sb3.redis.seckill.domain.ItemStock;
import org.zmz.sb3.redis.seckill.service.ItemService;
import org.zmz.sb3.redis.seckill.service.ItemStockService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private ItemStockService itemStockService;

    @GetMapping("list")
    public PageDTO queryItemPage(
            @RequestParam(value = "page", defaultValue = "1") Integer page,
            @RequestParam(value = "size", defaultValue = "5") Integer size) {
        // 分页查询商品
        Page<Item> result = itemService.query()
                .ne("status", 3)
                .page(new Page<>(page, size));

        // 查询库存
        List<Item> list = result.getRecords().stream().peek(item -> {
            ItemStock stock = itemStockService.getById(item.getId());
            item.setStock(stock.getStock());
            item.setSold(stock.getSold());
        }).collect(Collectors.toList());

        // 封装返回
        return new PageDTO(result.getTotal(), list);
    }

    @PostMapping
    public void saveItem(@RequestBody Item item) {
        itemService.saveItem(item);
    }

    @PutMapping
    public void updateItem(@RequestBody Item item) {
        itemService.updateById(item);
    }

    @PutMapping("stock")
    public void updateStock(@RequestBody ItemStock itemStock) {
        itemStockService.updateById(itemStock);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        itemService.update().set("status", 3).eq("id", id).update();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable("id") Long id) {
        return itemService.query()
                .ne("status", 3).eq("id", id)
                .one();
    }

    @GetMapping("/stock/{id}")
    public ItemStock findStockById(@PathVariable("id") Long id) {
        return itemStockService.getById(id);
    }
}