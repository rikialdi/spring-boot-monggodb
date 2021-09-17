package com.binar.binar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(name = "pembeli")
public class Pembeli extends AbstractDate implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @Column(name = "hp",  length = 15)
    private String hp;

    @Column(name = "jk",  length = 15)
    private String jk;

    @Column(name = "alamat", columnDefinition="TEXT")
    private String alamat;

    @OneToOne(mappedBy = "pembeli")
    private PembeliDetail pembelidetail;

    @JsonIgnore
    @OneToMany(mappedBy = "pembeli")
    List<Transaksi> transaksi;




}
