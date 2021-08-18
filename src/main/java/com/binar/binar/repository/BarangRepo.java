package com.binar.binar.repository;


import com.binar.binar.entity.Barang;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BarangRepo extends PagingAndSortingRepository<Barang, Long> {
    @Query("select c from Barang c WHERE c.id = :id")
    public Barang getbyID(@Param("id") Long id);

    @Query("select c from Barang c")// nama class
    public List<Barang> getList();

}