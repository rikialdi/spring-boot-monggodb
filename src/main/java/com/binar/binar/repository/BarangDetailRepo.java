package com.binar.binar.repository;

import com.binar.binar.entity.BarangDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BarangDetailRepo extends JpaRepository<BarangDetail, Long> {

}
