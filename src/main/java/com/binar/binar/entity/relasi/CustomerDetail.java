//package com.binar.binar.entity.relasi;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@Entity
//@Setter
//@Getter
//public class CustomerDetail implements Serializable {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;
//
//    @Column(name = "status", nullable = false, length = 45)
//    private String status;
//
//    // step 4 :
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "id_customer", referencedColumnName = "id") // id_customer : nam colum : Foreign key
//    private Customer customer;
//
//    /*
//    1. bikin tabel customer
//    2. bikin tabel customerdetail
//    3. relasi : di customer : one to one
//    4. relasi : di customer Detail
//     */
//}
