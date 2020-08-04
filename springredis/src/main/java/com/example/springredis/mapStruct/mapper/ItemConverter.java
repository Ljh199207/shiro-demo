package com.example.springredis.mapStruct.mapper;

import com.example.springredis.mapStruct.dto.SkuDTO;
import com.example.springredis.mapStruct.pojo.Item;
import com.example.springredis.mapStruct.pojo.Sku;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author ljh
 * @date 2019-11-28 09:35
 */
@Mapper
public interface ItemConverter {
    ItemConverter INSTANCE = Mappers.getMapper(ItemConverter.class);

    @Mappings({
            @Mapping(source = "sku.id", target = "skuId"),
            @Mapping(source = "sku.code", target = "skuCode"),
            @Mapping(source = "sku.price", target = "skuPrice"),
            @Mapping(source = "item.id", target = "itemId"),
            @Mapping(source = "item.title", target = "itemName")
    })
    SkuDTO domain2dto(Item item, Sku sku);

}
