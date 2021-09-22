package com.binar.binar.service.impl;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Jenis;
import com.binar.binar.repository.JenisRepo;
import com.binar.binar.service.JenisService;
import com.binar.binar.utils.BadResourceException;
import com.binar.binar.utils.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.util.StringUtils;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class JenisImpl implements JenisService {
    @Autowired
    public JenisRepo repoJenis;

    @Override
    public List<Jenis> listJenisTymeleaf(int pageNumber, int ROW_PER_PAGE) {
        return null;
    }

    @Override
    public boolean existsByIdTymeleaf(Long id) {
        return repoJenis.existsById(id);
    }

    @Override
    public Jenis findByIdTymeleaf(Long id) throws ResourceNotFoundException {
        Jenis jenis = repoJenis.findById(id).orElse(null);
        if (jenis==null) {
            throw new ResourceNotFoundException("Cannot find Jenis with id: " + id);
        }
        else return jenis;
    }

    @Override
    public Jenis saveTymeleaf(Jenis jenis) throws BadResourceException {
        return repoJenis.save(jenis);
    }

    @Override
    public void updateTymeleaf(Jenis jenis) throws ResourceNotFoundException, BadResourceException {
        repoJenis.save(jenis);
    }

    @Override
    public void deleteByIdTymeleaf(Long id) throws ResourceNotFoundException {
        if (!existsByIdTymeleaf(id)) {
            throw new ResourceNotFoundException("Cannot find jenis with id: " + id);
        }
        else {
            Jenis a = repoJenis.getbyID(id);
            a.setDeleted_date(new Date()); // unahtnagal deleted_date
            repoJenis.save(a); //simpan
        }
    }
}
