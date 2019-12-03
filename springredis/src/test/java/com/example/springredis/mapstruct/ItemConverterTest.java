package com.example.springredis.mapstruct;

import com.example.springredis.mapStruct.dto.SkuDTO;
import com.example.springredis.mapStruct.mapper.ItemConverter;
import com.example.springredis.mapStruct.pojo.Item;
import com.example.springredis.mapStruct.pojo.Sku;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author ljh
 * @date 2019-11-28 09:38
 */
@SpringBootTest
public class ItemConverterTest {
    @Test
    public void test() {
        Item item = new Item(1L, "iPhone X");
        Sku sku = new Sku(2L, "phone12345", 1000000);
        SkuDTO skuDTO = ItemConverter.INSTANCE.domain2dto(item, sku);
        assertNotNull(skuDTO);
        assertEquals(skuDTO.getSkuId(),sku.getId());
        assertEquals(skuDTO.getSkuCode(),sku.getCode());
        assertEquals(skuDTO.getSkuPrice(),sku.getPrice());
        assertEquals(skuDTO.getItemId(),item.getId());
        assertEquals(skuDTO.getItemName(),item.getTitle());
    }
}
