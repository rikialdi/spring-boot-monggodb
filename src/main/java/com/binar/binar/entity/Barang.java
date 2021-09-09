package com.binar.binar.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;//wajib untuk mysql
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "barang")
public class Barang implements Serializable {// sequesnse
// in mysql
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy=GenerationType.IDENTITY)
//    private Long id;

    @Id  // menyatakan primary key
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO) // automatis  ID ++
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Column(name = "stok", nullable = false, length = 11)
    private int stok;

    @Column(name = "satuan", nullable = false, length = 45)
    private String satuan;

    @Column(name = "harga", nullable = false, length = 11)
    private int harga;



    @ManyToOne(targetEntity = Supplier.class, cascade = CascadeType.ALL)
    private Supplier supplier;//ok

    @JsonIgnore
    @OneToMany(mappedBy = "barang")
    private Set<Transaksi> transaksi;

    //
//    @Column
//    @Temporal(TemporalType.DATE)
//    @JsonFormat(pattern="dd-MM-yyyy") //1997-10-10
//    private Date date;
//
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
//    private Date datetime;
//
//    @DateTimeFormat(pattern = "dd-mm-yyyy")
////    @Column(columnDefinition = "date")
//    public Date tanggalLahir;

    }


