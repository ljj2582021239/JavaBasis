package com.indiv.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchMethodException {
        /**
         * 获取Class对象的三种方法
         */
        // 1、`类名.class`：这种获取方式只有在`编译`前已经声明了该类的类型才能获取到 Class 对象
        Class clazz = SmallPineapple.class;

        // 2、`实例.getClass()`：通过实例化对象获取该实例的 Class 对象
        SmallPineapple pineapple = new SmallPineapple();
        Class clazz1 = pineapple.getClass();

        // 3、Class.forName(className)：通过类的全限定名获取该类的 Class 对象， 可能会出现ClassNotFoundException，受检查异常
        Class clazz2 = Class.forName("com.indiv.reflection.SmallPineapple");

        System.out.println("SmallPineapple.class: "+clazz);
        System.out.println("instance.getClass(): "+clazz1);
        System.out.println("Class.forName(): "+clazz2);
        System.out.println("===================================================================");
        System.out.println("Class.forName() == SmallPineapple.class:" + (clazz2 == clazz1));
        System.out.println("Class.forName() == instance.getClass():" + (clazz2 == clazz1));
        System.out.println("instance.getClass() == SmallPineapple.class:" + (clazz1 == clazz));

        System.out.println("===================================================================");
        // 构造类的实例化对象，两种方法
        // 可能会出现异常：IllegalAccessException, InstantiationException
        // 1、newInstance() 默认调用的无参构造方法
        SmallPineapple smallPineapple = (SmallPineapple) clazz.newInstance();
        smallPineapple.getInfo();

        // 2、Constructor 构造器调用newInstance()方法
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        constructor.setAccessible(true);
        SmallPineapple instance = (SmallPineapple)constructor.newInstance("小菠萝", 22);
        instance.getInfo();

        Method getInfo = clazz.getMethod("getInfo");


    }
}
