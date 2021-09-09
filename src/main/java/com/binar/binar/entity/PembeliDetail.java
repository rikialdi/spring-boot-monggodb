package com.binar.binar.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@Entity
@Table(name = "pembelidetail")
public class PembeliDetail implements Serializable {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "status", nullable = false, length = 45)
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_pembeli", referencedColumnName = "id")
    private Pembeli pembeli;
}
