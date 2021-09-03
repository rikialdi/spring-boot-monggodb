package com.binar.binar.service;

import com.binar.binar.entity.Barang;

import java.util.List;
import java.util.Map;

public interface BarangService {
    public Map insert(Barang barang);

    public Map update(Barang barang);

    public Map delete(Long barang);

    public Map getAll();


}
