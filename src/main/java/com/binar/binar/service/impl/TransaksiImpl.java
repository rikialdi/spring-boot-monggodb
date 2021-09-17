package com.binar.binar.service.impl;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Pembeli;
import com.binar.binar.entity.Supplier;
import com.binar.binar.entity.Transaksi;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.repository.PembeliRepo;
import com.binar.binar.repository.TransaksiRepo;
import com.binar.binar.service.TransaksiService;
import com.binar.binar.utils.MyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@Transactional
public class TransaksiImpl implements TransaksiService {
    @Autowired
    public TransaksiRepo repoTransaksi;

    @Autowired
    public BarangRepo repoBarang;

    @Autowired
    public PembeliRepo repoPembeli;

    MyConfig config = new MyConfig();


//            {
//                "barang" :
//                       { "id":1,
//                        nama : "apa"},
//                "pembeli":
//                      { "id":1  }
//            }

    // cara lain get id
//            Optional<Pembeli> a = repoPembeli.findById(transaksi.getPembeli().getId());

    @Override
    public Map insert(Transaksi transaksi) {
        Map map = new HashMap();
        try {
            if(transaksi.getBarang() == null){
                map.put(config.getStatusCode(), config.getStatusNotfoundCode());
                map.put(config.getStatusMessage(),config.getStatusNotfoundDesc() );
                return map;// respon
            }
            Barang barang = repoBarang.getbyID(transaksi.getBarang().getId());
            if(barang == null){
                map.put(config.getStatusCode(), config.getStatusNotfoundCode());
                map.put(config.getStatusMessage(),config.getStatusNotfoundDesc() );
                return map;// respon
            }
            Pembeli pembeli = repoPembeli.getbyID(transaksi.getPembeli().getId());
            transaksi.setBarang(barang);
            transaksi.setPembeli(pembeli);
            Transaksi trx = repoTransaksi.save(transaksi);

            map.put(config.getData(), trx);
            map.put(config.getStatusCode(), config.getStatusSuksesCode());
            map.put(config.getStatusMessage(), config.getStatusSuksesDesc());
            return map;// respon

        } catch (Exception e) {
            e.printStackTrace();
            map.put(config.getStatusCode(), config.getStatusFailCode());
            map.put(config.getStatusMessage(), e);
            return map;
        }
    }

    @Override
    public Map getData() {
        return null;
    }
}
