package org.zmz.sb3.redis.seckill.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("tb_item")
public class Item {
    //商品id
    @TableId(type = IdType.AUTO)
    private Long id;
    //商品名称
    private String name;
    //商品标题
    private String title;
    //价格（分）
    private Long price;
    //商品图片
    private String image;
    //分类名称
    private String category;
    //品牌名称
    private String brand;
    //规格
    private String spec;
    //商品状态 1-正常，2-下架
    private Integer status;
    //创建时间
    private Date createTime;
    //更新时间
    private Date updateTime;
    @TableField(exist = false)
    private Integer stock;
    @TableField(exist = false)
    private Integer sold;
}