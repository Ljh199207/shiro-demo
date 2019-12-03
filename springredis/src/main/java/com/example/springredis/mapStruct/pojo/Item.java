package com.example.springredis.mapStruct.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ljh
 * @date 2019-11-28 09:33
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Item {
    private Long id;
    private String title;
}
