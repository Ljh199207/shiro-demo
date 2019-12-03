package com.example.springredis.mapStruct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljh
 * @date 2019-11-28 09:34
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class SkuDTO {
    private Long skuId;
    private String skuCode;
    private Integer skuPrice;
    private Long itemId;
    private String itemName;
}
