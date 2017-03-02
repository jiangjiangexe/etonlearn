package com.jiang.etonlearn.play;

import java.lang.reflect.Field;

public class AssignFieldDemo {
    public static void main(String[] args) {
        try {
            // getFields() & getDeclaredFields() difference
            // getFields()获得某个类的所有的公共（public）的字段，包括父类。
            // getDeclaredFields()获得某个类的所有申明的字段，即包括public、private和proteced，但是不包括父类的申明字段。
            // 同样类似的还有getConstructors()和getDeclaredConstructors()，getMethods()和getDeclaredMethods()。
            args = new String[]{"com.jiang.etonlearn.play.TestField"};
            Class c = Class.forName(args[0]);
            Object targetObj = c.newInstance();

            Field testInt = c.getField("testInt");
            testInt.setAccessible(true);
            testInt.setInt(targetObj, 99);

            Field testString = c.getField("testString");
            testString.set(targetObj, "caterpillar");

            System.out.println(targetObj);
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("沒有指定類別");
        } catch (ClassNotFoundException e) {
            System.out.println("找不到指定的類別");
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            System.out.println("找不到指定的資料成員");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
