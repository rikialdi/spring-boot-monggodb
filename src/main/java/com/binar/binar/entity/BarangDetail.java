package com.binar.binar.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "barangdetail")
public class BarangDetail  implements Serializable {

    @Id  // menyatakan primary key
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO) // automatis  ID ++
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String nama;

    @JsonIgnore // wajib di ignore salah satu
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_barang", referencedColumnName = "id")
    private Barang detailbarang;
}
