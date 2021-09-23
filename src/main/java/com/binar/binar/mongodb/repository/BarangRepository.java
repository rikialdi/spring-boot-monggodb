package com.binar.binar.mongodb.repository;


import com.binar.binar.mongodb.model.Barang;
import com.binar.binar.mongodb.model.Tutorial;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BarangRepository extends MongoRepository<Barang, String> {
    List<Barang> findByNamaContaining(String nama);
}
