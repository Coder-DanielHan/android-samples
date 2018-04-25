package com.danielhan.javareflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @author DanielHan
 * @date 2018/4/24
 */
public class Hello {
    public static void main(String[] args) {
        Class<?> demo = null;
        try {
            demo = Class.forName("com.danielhan.javareflection.Person");
        } catch (Exception e) {
            e.printStackTrace();
        }
//        getInterfaces(demo);
//        getInstanceByDefaultConstructor(demo);
//        getInstance(demo);
//        getSuperClass(demo);
//        getConstructors(demo);
//        getMethods(demo);
        getFields(demo);
    }

    private static void getInstanceByDefaultConstructor(Class<?> demo) {
        Person person = null;
        try {
            person = (Person) demo.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(person);
    }

    private static void getInstance(Class<?> demo) {
        Person person = null;
        Constructor<?>[] constructors = demo.getConstructors();
        if (constructors.length == 2) {
            try {
                person = (Person) constructors[1].newInstance("男");
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
        System.out.println(person);
    }

    private static void getInterfaces(Class<?> demo) {
        //保存所有的接口
        Class<?> intes[] = demo.getInterfaces();
        for (int i = 0; i < intes.length; i++) {
            System.out.println("实现的接口   " + intes[i].getName());
        }
    }

    private static void getSuperClass(Class<?> demo) {
        Class<?> superClass = demo.getSuperclass();
        System.out.println(superClass.getName());
    }

    private static void getConstructors(Class<?> demo) {
        Constructor<?>[] constructors = demo.getConstructors();
        for (Constructor<?> constructor : constructors) {
            System.out.println("constructor:" + constructor);
            System.out.println("name:" + constructor.getName());
            System.out.println("modifier:" + Modifier.toString(constructor.getModifiers()));
            Class<?>[] parameterTypes = constructor.getParameterTypes();
            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameter:" + parameterType.getName());
            }
            System.out.println("------------------------------------------------------------");
        }
    }

    private static void getMethods(Class<?> demo) {
        Method[] methods = demo.getMethods();
        for (Method method : methods) {
            System.out.print(Modifier.toString(method.getModifiers()) + " ");
            Class<?> returnType = method.getReturnType();
            System.out.print(returnType.getSimpleName() + " ");
            System.out.print(method.getName() + "(");
            Class<?>[] parameterTypes = method.getParameterTypes();
            for (int i = 0; i < parameterTypes.length; i++) {
                Class<?> parameterType = parameterTypes[i];
                if (i != parameterTypes.length - 1) {
                    System.out.print(parameterType.getSimpleName() + " arg" + i + ",");
                } else {
                    System.out.print(parameterType.getSimpleName() + " arg" + i);
                }
            }
            System.out.print(")");
            Class<?>[] exceptionTypes = method.getExceptionTypes();
            if (exceptionTypes.length > 0) {
                System.out.print(" throws ");
            }
            for (int i = 0; i < exceptionTypes.length; i++) {
                if (i != exceptionTypes.length - 1) {
                    System.out.print(exceptionTypes[i].getCanonicalName() + ",");
                } else {
                    System.out.print(exceptionTypes[i].getCanonicalName());
                }
            }
            System.out.println("");
        }
    }

    private static void getFields(Class<?> demo) {
        System.out.println("===============本类属性========================");
        Field[] declaredFields = demo.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.print(Modifier.toString(declaredField.getModifiers()) + " ");
            Class<?> type = declaredField.getType();
            System.out.print(type.getName() + " ");
            System.out.println(declaredField.getName() + ";");
        }
        System.out.println("===============实现的接口或者父类的属性========================");
        Field[] fields = demo.getFields();
        for (Field field : fields) {
            System.out.print(Modifier.toString(field.getModifiers()) + " ");
            Class<?> type = field.getType();
            System.out.print(type.getName() + " ");
            System.out.println(field.getName() + ";");
        }
    }
}
