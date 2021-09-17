package com.binar.binar.controller;


import com.binar.binar.entity.Pembeli;
import com.binar.binar.entity.Transaksi;
import com.binar.binar.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/transaksi")
public class TransaksiController {
    @Autowired
    public TransaksiService service;

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody Transaksi objModel) {

        Map map = new HashMap();
        Map obj = service.insert(objModel);

        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = service.getData();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }
}
