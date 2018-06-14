package com.danielhan.javareflection.annotation;

import java.lang.reflect.Proxy;

public class ProxyTest {

    public static void main(String[] args) {
//        MaoTaiWine maoTaiWine = new MaoTaiWine();
//        StaticBar staticBar = new StaticBar(maoTaiWine);
//        staticBar.sayName();

        MaoTaiWine maoTaiWine = new MaoTaiWine();
        DynamicBar dynamicBar = new DynamicBar(maoTaiWine);
        Wine proxy = (Wine) Proxy.newProxyInstance(MaoTaiWine.class.getClassLoader(), MaoTaiWine.class.getInterfaces(), dynamicBar);
        proxy.sayName();
    }
}
