package com.binar.binar.praktek;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v2/praktek2/")
public class PraktekController {

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return   "Hello Spring Boot";
    }
}
