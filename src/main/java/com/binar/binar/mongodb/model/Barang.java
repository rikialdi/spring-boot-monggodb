package com.binar.binar.mongodb.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "barang")
public class Barang {

    @Id
    private String id;

    private String nama;
    private Integer stok;
    private String satuan;
    private Integer harga;

}
