package com.binar.binar.controller;


import com.binar.binar.entity.JenisBarang;
import com.binar.binar.entity.Pembeli;
import com.binar.binar.service.JenisBarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/tjb/")
public class TransaksiJenisBarang {

    @Autowired
    public JenisBarangService serviceJB;

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody JenisBarang objModel) {

        Map map = new HashMap();
        Map obj = serviceJB.insert(objModel);

        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = serviceJB.getData();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

}
