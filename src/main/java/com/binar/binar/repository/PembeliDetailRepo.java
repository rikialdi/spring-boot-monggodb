package com.binar.binar.repository;

import com.binar.binar.entity.Pembeli;
import com.binar.binar.entity.PembeliDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

    @Repository
    public interface PembeliDetailRepo extends JpaRepository<PembeliDetail, Long> {

}
