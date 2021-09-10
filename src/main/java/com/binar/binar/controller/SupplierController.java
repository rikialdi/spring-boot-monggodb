package com.binar.binar.controller;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import com.binar.binar.repository.SupplierRepo;
import com.binar.binar.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/v1/supplier")
public class SupplierController {
    @Autowired
    public SupplierService serviceSupp;

    @Autowired
    public SupplierRepo repo;

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity<Map> getpage2(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String namashort,
            @RequestParam() String typeShort) {
        Map map = new HashMap();
        String getshorting = namashort.equals("") ? "id" : namashort;
        Pageable show_data;
        if(typeShort.equals("desc")){ //desc or asc
              show_data = PageRequest.of(page, size, Sort.by(getshorting).descending());
        }else{
            show_data = PageRequest.of(page, size, Sort.by(getshorting).ascending());
        }

//
                map.put("data", repo.findAll(show_data));
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {

        Map map = new HashMap();
//        Map c = servis.delete(id);
        Supplier obj = repo.getbyID(id);
        obj.setDeleted_date(new Date());
        repo.save(obj);
        map.put("data", "sukses delete");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }
}
