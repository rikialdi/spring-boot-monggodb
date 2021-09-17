package com.binar.binar.repository;

import com.binar.binar.entity.Pembeli;
import com.binar.binar.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransaksiRepo extends JpaRepository<Transaksi, Long> {
    @Query("select c from Transaksi c")// nama class
    public List<Transaksi> getList();
}
