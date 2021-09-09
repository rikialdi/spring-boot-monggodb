package com.binar.binar.controller;

import com.binar.binar.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/v1/supplier")
public class SupplierController {
    @Autowired
    public SupplierService serviceSupp;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Map> getList() {
        Map c = serviceSupp.getData();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }
}
