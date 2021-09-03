package com.binar.binar.iocdandi.contoh1.services;


import com.binar.binar.iocdandi.contoh1.domains.Karyawan;
import com.binar.binar.iocdandi.contoh1.domains.Perusahaan;

public class PerusahaanService {

    private Perusahaan perusahaan;

    public PerusahaanService() {

        Karyawan karyawan =new Karyawan();
        this.perusahaan = new Perusahaan(karyawan);

    }



}
