package com.binar.binar.service;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.JenisBarang;
import com.binar.binar.utils.BadResourceException;
import com.binar.binar.utils.ResourceNotFoundException;

import java.util.List;
import java.util.Map;

public interface JenisBarangService {
    public Map insert(JenisBarang jenisBarang);
    public Map getData();


}
