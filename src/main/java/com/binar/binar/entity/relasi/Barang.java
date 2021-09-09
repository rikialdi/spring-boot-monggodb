//package com.binar.binar.entity.relasi;
//
//import com.binar.binar.entity.relasi.Supplier;
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.List;
//
//@Setter
//@Getter
//@Entity
//@Table(name = "barang")
//public class Barang  implements Serializable {
//    @Id  // menyatakan primary key
//    @Column(name="id")
//    @GeneratedValue(strategy = GenerationType.AUTO) // automatis  ID ++
//    private Long id;
//
//    @Column(name = "nama", nullable = false, length = 45)
//    private String nama;
//
//    @Column(name = "stok", nullable = false, length = 11)
//    private int stok;
//
//    @Column(name = "satuan", nullable = false, length = 45)
//    private String satuan;
//
//    @Column(name = "harga", nullable = false, length = 11)
//    private int harga;
//
//    //step 4
//    @ManyToOne(targetEntity = Supplier.class, cascade = CascadeType.ALL)
//    private Supplier supplier;//ok supplier_id //
//
//    // transaksi
//    @OneToMany(mappedBy = "barang")
//    private List<Transaksi> transaksi;
//
//
//}
