package com.binar.binar.praktek;

import com.binar.binar.BinarApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/praktek/")
class Example {
    private static final Logger logger = LoggerFactory.getLogger(BinarApplication.class);

    @RequestMapping("/")
    @ResponseBody
    public String hello() {
      return   "Hello Spring Boot";
    }

    @Value("${spring.application.name}")
    private String name;

    @RequestMapping("/nameapp")
    @ResponseBody
    public String getNameApp() {
        logger.info("this is a info message");
        logger.warn("this is a warn message");
        logger.error("this is a error message");
        return   name;
    }
}