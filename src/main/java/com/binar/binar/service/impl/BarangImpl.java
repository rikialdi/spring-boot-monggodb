package com.binar.binar.service.impl;

import com.binar.binar.entity.Barang;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class BarangImpl implements BarangService {

    @Autowired// ini wajib
    public BarangRepo repo;


    @Override
    public Map insert(Barang barang) {
        Map map = new HashMap();
        try {
  /*
    id = id ,
    nama  = \
    localho : port /api/path
   */
            Barang obj = repo.save(barang);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(Barang barang) {
        Map map = new HashMap();
        try {

            Barang obj = repo.getbyID(barang.getId());
            obj.setNama(barang.getNama());
            obj.setHarga(obj.getHarga());
            obj.setSatuan(obj.getSatuan());
            obj.setStok(obj.getStok());

            repo.save(obj);
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Update Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map delete(Long idbarang) {
        Map map = new HashMap();
        try {

            Barang obj = repo.getbyID(idbarang);

            repo.deleteById(obj.getId());
            map.put("statusCode", "200");
            map.put("statusMessage", "Delete Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map  getAll() {
        List<Barang> list = new ArrayList<Barang>();
        Map map = new HashMap();
        try {

            list = repo.getList();
            map.put("data", list);
            map.put("statusCode", "200");
            map.put("statusMessage", "Delete Sukses");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }


}
