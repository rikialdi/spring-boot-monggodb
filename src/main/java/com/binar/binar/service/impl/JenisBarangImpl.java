package com.binar.binar.service.impl;

import com.binar.binar.entity.*;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.repository.JenisBarangRepo;
import com.binar.binar.repository.JenisRepo;
import com.binar.binar.service.JenisBarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //service wajib
@Transactional // opsional :
public class JenisBarangImpl implements JenisBarangService {
    @Autowired
    JenisBarangRepo repoJenisBarang;

    @Autowired
    JenisRepo repoJenis;

    @Autowired
    BarangRepo repoBarang;

    @Override
    public Map insert(JenisBarang jenisBarang) {
        Map map = new HashMap();
        try {
            Barang barang = repoBarang.getbyID(jenisBarang.getBarang().getId());
            Jenis jenis = repoJenis.getbyID(jenisBarang.getJenis().getId());

            jenisBarang.setBarang(barang);
            jenisBarang.setJenis(jenis);

            JenisBarang jB = repoJenisBarang.save(jenisBarang);

            map.put("data", jB);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            String Abstract = "234";
            return map;// respon

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map getData() {
        List<JenisBarang> list = new ArrayList<JenisBarang>();
        Map map = new HashMap();
        try {

            list = repoJenisBarang.getList();
            map.put("data", list);//data
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;//success

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;// eror
        }
    }
}
