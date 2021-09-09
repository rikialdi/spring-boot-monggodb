package com.binar.binar.service;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;

import java.util.Map;

public interface SupplierService {
     public Map insert(Supplier supplier);

     public Map update(Supplier supplier);

     public Map getData();
}
