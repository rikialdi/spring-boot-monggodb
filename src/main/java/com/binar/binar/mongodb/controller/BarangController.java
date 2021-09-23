package com.binar.binar.mongodb.controller;

import com.binar.binar.mongodb.model.Barang;
import com.binar.binar.mongodb.model.Tutorial;
import com.binar.binar.mongodb.repository.BarangRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/v1/barang")
//@AllArgsConstructor
public class BarangController {

    @Autowired
    public BarangRepository repo;

    @GetMapping("")
    public ResponseEntity<List<Barang>> getAll(@RequestParam(required = false) String nama) {
        try {
            List<Barang> barangs = new ArrayList<Barang>();

            if (nama == null)
                repo.findAll().forEach(barangs::add);
            else
                repo.findByNamaContaining(nama).forEach(barangs::add);

            if (barangs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(barangs, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<Barang> create(@RequestBody Barang barang) {
        try {
            Barang obj = repo.save(barang);
            return new ResponseEntity<>(obj, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
