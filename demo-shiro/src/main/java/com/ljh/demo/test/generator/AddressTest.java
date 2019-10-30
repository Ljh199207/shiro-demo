package com.ljh.demo.test.generator;

import com.ljh.demo.common.utils.AddressUtil;

/**
 * @author ljh
 */
public class AddressTest {

    public static void main(String[] args) {
        String cityInfo = AddressUtil.getCityInfo("192.168.215.149");
        System.out.println(cityInfo);
    }
}
