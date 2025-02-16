package org.zmz.sb3.redis.seckill.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.zmz.sb3.redis.seckill.domain.ItemStock;
import org.zmz.sb3.redis.seckill.mapper.ItemStockMapper;

@Service
public class ItemStockService extends ServiceImpl<ItemStockMapper, ItemStock> {
}
