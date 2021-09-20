package com.binar.binar.controller;

import com.binar.binar.entity.Barang;
import com.binar.binar.service.BarangRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/rt/")
public class BarangRestTemplateController {

    @Autowired
    public BarangRestTemplateService service;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Map> getList() {
        Map c = service.getData();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @PostMapping("/save/{idsupplier}")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier,@Valid @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map obj = service.insert(objModel, idsupplier);


        map.put("data", obj);
        map.put("", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }


}
