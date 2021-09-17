package com.binar.binar.service;

import com.binar.binar.entity.Barang;

import java.util.Map;

public interface BarangRestTemplateService {
    public Map insert(Barang barang, Long idsupplier);// request lempar objek

    public Map update(Barang barang, Long idsupplier); //DI objek request

    public Map delete(Barang barang);// delete by id

    public Map getData(); // nampilin semua data

}
