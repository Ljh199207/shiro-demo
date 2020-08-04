package com.example.demojava.java8.one;

/**
 * @author ljh
 * @date 2019-11-27 17:02
 */
public class ForMulaImpl implements Formula {

    @Override
    public double calculate(int a) {
        return sqrt(a * 100);
    }


}
