package com.binar.binar.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//step 1
@Setter
@Getter
public class ModelBarang {
    private Long id;
    private String nama;
    private int stok;
    private String satuan;
    private int harga;
    public  ModelBarang(Long id, String nama){
        System.out.println("id ="+id + " nama="+nama);
        this.id = id;
        this.nama= nama;
    }
}
