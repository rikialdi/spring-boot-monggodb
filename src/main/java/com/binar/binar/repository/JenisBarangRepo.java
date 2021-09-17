package com.binar.binar.repository;

import com.binar.binar.entity.Jenis;
import com.binar.binar.entity.JenisBarang;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JenisBarangRepo extends JpaRepository<JenisBarang, Long> {
    @Query("select c from JenisBarang c")// nama class
    public List<JenisBarang> getList();
}
