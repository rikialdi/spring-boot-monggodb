package com.binar.binar.service;

import com.binar.binar.entity.Barang;
import com.binar.binar.utils.BadResourceException;
import com.binar.binar.utils.ResourceNotFoundException;

import java.util.List;

public interface BarangTymeleafService {
    public List<Barang> listBarangTymeleaf(int pageNumber, int ROW_PER_PAGE );

    public boolean existsByIdTymeleaf(Long id);

    public Barang findByIdTymeleaf(Long id) throws ResourceNotFoundException;

    public   Barang saveTymeleaf(Barang barang) throws BadResourceException;

    public void updateTymeleaf(Barang barang) throws ResourceNotFoundException, BadResourceException;

    public void deleteByIdTymeleaf(Long id) throws ResourceNotFoundException;
}
