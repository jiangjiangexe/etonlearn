package com.jiang.etonlearn;

import org.springframework.mock.web.MockHttpServletRequest;

import java.lang.reflect.Method;
import java.util.Enumeration;

public class ClassDemo {
    public static void main(String[] args) {
        String name = "caterpillar";
        Class stringClass = name.getClass();
        System.out.println("類別名稱：" +
                stringClass.getName());
        System.out.println("是否為介面：" +
                stringClass.isInterface());
        System.out.println("是否為基本型態：" +
                stringClass.isPrimitive());
        System.out.println("是否為陣列物件：" +
                stringClass.isArray());
        System.out.println("父類別名稱：" +
                stringClass.getSuperclass().getName());

        try {
            Class c = Class.forName("com.jiang.etonlearn.config.Application");
            System.out.println("類別名稱：" +
                    c.getName());
            System.out.println("是否為介面：" +
                    c.isInterface());
            System.out.println("是否為基本型態：" +
                    c.isPrimitive());
            System.out.println("是否為陣列：" + c.isArray());
            System.out.println("父類別：" +
                    c.getSuperclass().getName());

            Method[] methodArray = c.getMethods();
            for (Method method : methodArray) {
                System.out.println("Return" + method.getReturnType().getName() + "Name" + method.getName());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        rock();
    }

    static void rock() {
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.addParameter("rock", "zero");
        request.addParameter("maga", new String[]{"ggxx", "otz"});
        Enumeration<String> parameterNames = request.getParameterNames();

        while (parameterNames.hasMoreElements()) {

            String s = parameterNames.nextElement();
            s = request.getParameter(s);
            System.out.println(s);
        }
    }
}
