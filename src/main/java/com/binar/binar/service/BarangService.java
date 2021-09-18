package com.binar.binar.service;

import com.binar.binar.entity.Barang;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

/*
1. create package service
2. create class interdace BarangService
3. Create method
 */
public interface BarangService {
    public Map insert(Barang barang,Long idsupplier);// request lempar objek

    public Map update(Barang barang, Long idsupplier); //DI objek request

    public Map delete(Long barang);// delete by id

    public Map getAll(); // nampilin semua data

    public Map findByNama(String nama, Integer page, Integer size);

    Page<Barang> findByNamaLike(String nama, Pageable pageable);

    public Map getAllNative();





}
