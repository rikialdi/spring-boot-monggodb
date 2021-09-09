package com.binar.binar.controller;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import com.binar.binar.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
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

    @PostMapping("/save")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@Valid @RequestBody Supplier objModel) {

        Map map = new HashMap();
        Map obj = serviceSupp.insert(objModel);

        map.put("data", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody Supplier objModel) {

        Map map = new HashMap();
        Map c = serviceSupp.update(objModel);

        map.put("data", c);
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }
}
