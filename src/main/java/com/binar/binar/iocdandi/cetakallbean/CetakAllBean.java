package com.binar.binar.iocdandi.cetakallbean;


import java.util.Arrays;
import java.util.List;

import com.binar.binar.iocdandi.AppConfiguration;
import com.binar.binar.iocdandi.HelloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CetakAllBean {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(CetakAllBean.class);
        System.out.println("Daftar beans");
        List<String> listContainer = Arrays.asList(applicationContext.getBeanDefinitionNames());
        for (String bean : listContainer) {
            System.out.println("Bean name: " + bean);
        }
    }
}