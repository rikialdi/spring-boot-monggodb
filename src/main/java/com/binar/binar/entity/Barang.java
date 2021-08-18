package com.binar.binar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;//wajib
import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "barang")
public class Barang implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Column(name = "stok", nullable = false, length = 11)
    private int stok;

    @Column(name = "satuan", nullable = false, length = 45)
    private String satuan;

    @Column(name = "harga", nullable = false, length = 11)
    private int harga;
    }


