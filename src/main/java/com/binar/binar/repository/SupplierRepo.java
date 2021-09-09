package com.binar.binar.repository;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepo  extends JpaRepository<Supplier, Long>  {

    @Query("select c from Supplier c")// nama class
    public List<Supplier> getList();

    @Query("select c from Supplier c WHERE c.id = :id")
    public Supplier getbyID(@Param("id") Long id);
/*
1. bikin entitas class : supplier : done
2. repo supplier : done
3. interface supplier : insert
4. impl supplir
5. controller

 */
}
