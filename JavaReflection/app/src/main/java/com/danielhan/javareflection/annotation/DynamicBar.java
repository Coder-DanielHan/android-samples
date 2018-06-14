package com.danielhan.javareflection.annotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DynamicBar implements InvocationHandler {
    private Wine wine;

    public DynamicBar(Wine wine) {
        this.wine = wine;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("before");
        method.invoke(wine, objects);
        System.out.println("after");
        return null;
    }
}
