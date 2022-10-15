package com.woquiz.common.utils;

import java.util.HashMap;
import java.util.Map;

public class EnumMapper<F,B> {

    private Map<F,B> frontToBack = new HashMap<>();
    private Map<B,F> backToFront = new HashMap<>();

    public EnumMapper<F,B> add(F front, B back){
        frontToBack.put(front, back);
        backToFront.put(back, front);
        return this;
    }

    public B toBack(F front){
        return frontToBack.get(front);
    }

    public F toFront(B back){
        return backToFront.get(back);
    }
}

