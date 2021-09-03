package com.binar.binar.iocdandi.contoh1;


import com.binar.binar.iocdandi.contoh1.domains.Perusahaan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        // IoC
        ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
        Perusahaan perusahaan = (Perusahaan) ctx.getBean("perusahaan");
        System.out.println(perusahaan);
    }
}
