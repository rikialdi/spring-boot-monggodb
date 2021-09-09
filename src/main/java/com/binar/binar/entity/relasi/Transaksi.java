//package com.binar.binar.entity.relasi;
//
//import com.binar.binar.entity.AuditDate;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.CreationTimestamp;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//
//@Setter
//@Getter
//@Entity
//public class Transaksi implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @CreationTimestamp
//    private Date tanggal;
//
//    // mapping barang
//    @ManyToOne
//    @JoinColumn(name = "id_barang")
//    private Barang barang;
//
//    //mapping customer
//    @ManyToOne
//    @JoinColumn(name = "id_customer")
//    private Customer customer;
//
//    /*
//    1. create table transaksi
//    2. relasi transaksi dengan barang
//    3. relasi transaksi dengan customer
//     */
//}
