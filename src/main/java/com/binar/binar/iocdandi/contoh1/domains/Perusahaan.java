package com.binar.binar.iocdandi.contoh1.domains;


public class Perusahaan {
    // DI
    private Karyawan karyawan;
    // IOC
    public Perusahaan(Karyawan karyawan) {
        this.karyawan = karyawan;
    }

    @Override
    public String toString() {
        return "Perusahaan [karyawan=" + karyawan + "]";
    }



}