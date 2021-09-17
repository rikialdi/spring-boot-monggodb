package com.binar.binar.service;

import com.binar.binar.entity.Transaksi;

import java.util.Map;

public interface TransaksiService {
    public Map insert(Transaksi transaksi);

    public Map getData();

}
