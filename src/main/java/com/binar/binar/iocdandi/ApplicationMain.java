package com.binar.binar.iocdandi;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationMain {

    public static void main(String[] args) {
        // Ioc
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);
        // DI
        HelloWorld obj = (HelloWorld) context.getBean("helloWorldBean");
        obj.getMessage();
        context.close();
    }
}
