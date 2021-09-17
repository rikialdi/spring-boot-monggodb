package com.binar.binar.repository;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.BarangDetail;
import com.binar.binar.entity.Jenis;
import com.binar.binar.entity.Pembeli;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JenisRepo extends JpaRepository<Jenis, Long> {


    @Query("select c from Jenis c WHERE c.id = :id")
    public Jenis getbyID(@Param("id") Long id);
}