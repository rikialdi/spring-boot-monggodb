package com.binar.binar.service;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Jenis;
import com.binar.binar.utils.BadResourceException;
import com.binar.binar.utils.ResourceNotFoundException;

import java.util.List;

public interface JenisService {
    public List<Jenis> listJenisTymeleaf(int pageNumber, int ROW_PER_PAGE );

    public boolean existsByIdTymeleaf(Long id);

    public Jenis findByIdTymeleaf(Long id) throws ResourceNotFoundException;

    public   Jenis saveTymeleaf(Jenis jenis) throws BadResourceException;

    public void updateTymeleaf(Jenis jenis) throws ResourceNotFoundException, BadResourceException;

    public void deleteByIdTymeleaf(Long id) throws ResourceNotFoundException;
}
