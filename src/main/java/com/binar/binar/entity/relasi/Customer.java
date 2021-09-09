//package com.binar.binar.entity.relasi;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//@Getter
//@Setter
//@Entity
//public class Customer implements Serializable {
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "nama", nullable = false, length = 45)
//    private String nama;
//
//    @Column(name = "hp",  length = 15)
//    private String hp;
//
//    @Column(name = "jk",  length = 15)
//    private String jk;
//
//    @Column(name = "alamat", columnDefinition="TEXT")
//    private String alamat;
//
//    // relasi one to one denngan tabel customer detail
//    @OneToOne(mappedBy = "customer")
//    private CustomerDetail customerdetail;
//
//    //transaksi
//    @OneToMany(mappedBy = "customer")
//    private List<Transaksi> transaksi;
//
//    /*
//    1. bikin tabel customer
//    2. bikin tabel customerdetail
//    3. relasi : di customer : one to one
//    4. relasi : di customer Detail
//     */
//}
