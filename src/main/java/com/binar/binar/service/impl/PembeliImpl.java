package com.binar.binar.service.impl;

import com.binar.binar.entity.*;
import com.binar.binar.repository.PembeliDetailRepo;
import com.binar.binar.repository.PembeliRepo;
import com.binar.binar.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //service wajib
@Transactional // opsional :
public class PembeliImpl  implements PembeliService {
    @Autowired
    public PembeliRepo repo;

    @Autowired
    public PembeliDetailRepo repoDetailPembeli;




    @Override
    public Map insert(Pembeli pembeli) {
        Map map = new HashMap();
        try {

//        {
//            "nama":"jhon",
//            "jk":"p",
//            "hp":"+822123",
//            "alamat":"Jl. sudirman",
//            "pembelidetail":{"status":"aktif"}
//
//        }
            /*
            id
            status
            id_pembeli
             */
            //add save detail barang
            PembeliDetail detailPembeli = repoDetailPembeli.save(pembeli.getPembelidetail());
            /*
            id : 1 , autoincremetn  seq
            status : aktif
            id_pembeli  == null obj.getid
             */
            Pembeli obj = repo.save(pembeli);

            // set id pembeli
            detailPembeli.setPembeli(obj); // set ID pembeli ; agar FK id terisi
            repoDetailPembeli.save(detailPembeli); // save detail pembeli

            map.put("data", obj);
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
        List<Pembeli> list = new ArrayList<Pembeli>();
        Map map = new HashMap();
        try {

            list = repo.getList();
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
