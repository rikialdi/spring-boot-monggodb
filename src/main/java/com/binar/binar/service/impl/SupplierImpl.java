package com.binar.binar.service.impl;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.repository.SupplierRepo;
import com.binar.binar.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service //service wajib
@Transactional // opsional :
public class SupplierImpl implements SupplierService {

    @Autowired
    public SupplierRepo repo;

    @Autowired
    public BarangRepo repoBarang;

    @Override
    public Map insert(Supplier supplier) {

        //suppliar sekaligus :insert si barang
        Map map = new HashMap();
        try {
            Supplier obj = repo.save(supplier); //JPA
            // ini tidak perlu: karena otomatis
//            if(obj.getBarang() !=null){
//                for(Barang objBarang : obj.getBarang()){
//                    objBarang.setSupplier(obj);
//                    repoBarang.save(objBarang);
//                }
//            }
            map.put("data", obj);
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;// respon

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }

//            {
//                "nama":"nama",
//                "hp":"123",
//                "alamat":"alamat",
//                "barang": [
//                        {
//                            "nama":"nama",
//                            "satuan":"pcs",
//                            "stok":"10",
//                            "harga":"100"
//                        },
//                        {
//                                "nama":"nama",
//                                "satuan":"pcs",
//                                "stok":"10",
//                                "harga":"100"
//                        }
//                        ]
//            }
    }

    @Override
    public Map getData() {
        List<Supplier> list = new ArrayList<Supplier>();
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
