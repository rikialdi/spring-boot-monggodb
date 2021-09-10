package com.binar.binar.controller;

import java.util.*;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.repository.SupplierRepo;
import com.binar.binar.service.BarangService;
import com.binar.binar.service.impl.BarangImpl;
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


    // ini wajib
    @Autowired
    public BarangRepo repo;

    @Autowired
    public SupplierRepo repoSupp;

//    @Autowired
//    public BarangImpl imp;

    @Autowired
    BarangService servis;


    @GetMapping("/listpage")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }


    @PostMapping("/save/{idsupplier}")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier,@Valid @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map obj = servis.insert(objModel, idsupplier);

        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @PutMapping("/update/{idsupplier}")
    public ResponseEntity<Map> update(@PathVariable(value = "idsupplier") Long idsupplier, @Valid @RequestBody Barang objModel ) {

        Map map = new HashMap();
        Map c = servis.update(objModel, idsupplier);

        map.put("Request =", objModel);
        map.put("Response =", c);
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {

        Map map = new HashMap();
//        Map c = servis.delete(id);
        Barang obj = repo.getbyID(id);
        obj.setDeleted_date(new Date());
        repo.save(obj);
        map.put("data", "sukses delete");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
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



//    @GetMapping("/listpage/supp")
//    @ResponseBody
//    public ResponseEntity<Map>  supp() {
//        Map map = new HashMap();
//      List<Supplier> s= repoSupp.getList();
//        map.put("data", s);
//        return new ResponseEntity<Map>(map, HttpStatus.OK);
//    }

}
