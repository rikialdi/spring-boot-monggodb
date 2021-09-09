//package com.binar.binar.entity.relasi;
//
//import com.binar.binar.entity.relasi.Barang;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//// langkah 1 : create tabel( relasi supplier dengan barang)
///*
// langkah 2 : buat tabel barang
// langkah 3 : relasi  : tambahkan relasi pada tabel supplier
// langkah 4 : tambahkan relasi di tabel barang (one-many)
// */
//@Getter
//@Setter
//@Entity
//@Table(name = "supplier")
//public class Supplier implements Serializable {
//    @Id
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "nama", nullable = false, length = 45)
//    private String nama;
//
//    @Column(name = "hp", nullable = false, length = 15)
//    private String hp;
//
//    @Column(name = "alamat", columnDefinition="TEXT")
//    private String alamat;
//
//    //step 3
////    @JsonIgnore  // hidden sebuah field : tidak ditampilkan saat get data : testing di postman
//    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//    private List<Barang> barang;
//}
