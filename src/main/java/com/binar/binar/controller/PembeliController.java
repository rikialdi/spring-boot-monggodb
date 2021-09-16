package com.binar.binar.controller;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Pembeli;
import com.binar.binar.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/pembeli/")
public class PembeliController {
    @Autowired
    PembeliService servicePembeli;

    @PostMapping("/save")
    public ResponseEntity<Map> save(@Valid @RequestBody Pembeli objModel) {

        Map map = new HashMap();
        Map obj = servicePembeli.insert(objModel);

        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @GetMapping("/listpage")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = servicePembeli.getData();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }
}
