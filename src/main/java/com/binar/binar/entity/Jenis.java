package com.binar.binar.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "jenis")
public class Jenis extends AbstractDate implements Serializable {

    @Id  // menyatakan primary key
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO) // automatis  ID ++
    private Long id;

    @Column(name = "nama", nullable = false, length = 45)
    private String jenis;

    @JsonIgnore
    @OneToMany(mappedBy = "jenis")
    private List<JenisBarang> jenisbarang;

}
