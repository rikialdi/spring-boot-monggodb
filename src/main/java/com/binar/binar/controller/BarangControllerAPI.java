package com.binar.binar.controller;

import java.util.HashMap;
import java.util.Map;

import com.binar.binar.entity.Barang;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;

import javax.validation.Valid;
@RestController
@RequestMapping("/v1/binar/")// localhost :8080/v1/binar
public class BarangControllerAPI {

    @Autowired
    BarangService servis;

    @Autowired// ini wajib
    public BarangRepo repo;

    @PostMapping("/save")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@Valid @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map obj = servis.insert(objModel);

        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<Map> update(@Valid @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map c = servis.update(objModel);

        map.put("Request =", objModel);
        map.put("Response =", c);
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {

        Map map = new HashMap();
        Map c = servis.delete(id);
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @GetMapping("/listpage")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @GetMapping("/listbynama")
    public ResponseEntity<Page<Barang>> getpage2(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Barang> list = repo.findByNama(nama, show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/listbynamalike")
    public ResponseEntity<Page<Barang>> listbynamalike(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama) {
        Pageable show_data = PageRequest.of(page, size);
//        Page<Barang> list = repo.findByNamaLike(nama, show_data);
        Page<Barang> list = repo.findByNamaLike("%"+nama+"%", show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }
}
