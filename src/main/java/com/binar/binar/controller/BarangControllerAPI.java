package com.binar.binar.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;

import com.binar.binar.controller.fileupload.UploadFileResponse;
import com.binar.binar.entity.Barang;
import com.binar.binar.entity.Supplier;
import com.binar.binar.model.ModelBarang;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.repository.SupplierRepo;
import com.binar.binar.service.BarangService;
import com.binar.binar.service.impl.BarangImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import org.springframework.http.HttpStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
@RestController
@RequestMapping("/v1/binar/")// localhost :8080/v1/binar
public class BarangControllerAPI {


    // ini wajib
    @Autowired //
    public BarangRepo repo;

    @Autowired
    public SupplierRepo repoSupp;

//    @Autowired
//    public BarangImpl imp;

    @Autowired
    BarangService servis;

    @Value("${app.uploadto.cdn}")//FILE_SHOW_RUL
    private String UPLOADED_FOLDER;


    @GetMapping("/listpage")
    @ResponseBody
    public ResponseEntity<Map>  getList() {
        Map c = servis.getAll();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    // step akhir DTO
    @GetMapping("/listpagenative")
    @ResponseBody
    public ResponseEntity<Map>  listpagenative() {
        Map c = servis.getAllNative();
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    // step akhir DTO untuk entitas
    @GetMapping("/listpageentitas")
    @ResponseBody
    public ResponseEntity<Map>  listpageentitas() {
        Map map = new HashMap();
        List<ModelBarang> obj = repo.modelDTO();
        map.put("data", obj);
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }


    @PostMapping("/save/{idsupplier}")// localhost :8080/v1/binar/save
    public ResponseEntity<Map> save(@PathVariable(value = "idsupplier") Long idsupplier,@Valid @RequestBody Barang objModel) {

        Map map = new HashMap();
        Map obj = servis.insert(objModel, idsupplier);


        map.put("Request =", objModel);
        map.put("Response =", obj);
        return new ResponseEntity<Map>(obj, HttpStatus.OK);// response
    }

    @PutMapping("/update/{idsupplier}")
    public ResponseEntity<Map> update(@PathVariable(value = "idsupplier") Long idsupplier, @Valid @RequestBody Barang objModel ) {

        Map map = new HashMap();
        Map c = servis.update(objModel, idsupplier);

        map.put("Request =", objModel);
        map.put("Response =", c);
        return new ResponseEntity<Map>(c, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map> delete(@PathVariable(value = "id") Long id) {

        Map map = new HashMap();
//        Map c = servis.delete(id);
        Barang obj = repo.getbyID(id);
        obj.setDeleted_date(new Date());
        repo.save(obj);
        map.put("data", "sukses delete");
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }



    @GetMapping("/listbynama")
    public ResponseEntity<Page<Barang>> getpage2(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama) {
        Pageable show_data = PageRequest.of(page, size);
        Page<Barang> list = repo.findByNama(nama, show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/listbynamalike")
    public ResponseEntity<Page<Barang>> listbynamalike(
            @RequestParam() Integer page,
            @RequestParam() Integer size,
            @RequestParam() String nama) {
        Pageable show_data = PageRequest.of(page, size);
//        Page<Barang> list = repo.findByNamaLike(nama, show_data);
        Page<Barang> list = repo.findByNamaLike("%"+nama+"%", show_data);
        return new ResponseEntity<Page<Barang>>(list, new HttpHeaders(), HttpStatus.OK);
    }


    @PostMapping(value = "/uploadsimpanbarang/{idsupplier}",consumes = {"multipart/form-data", "application/json"})// @RequestMapping(value = "/v1/uploadlansgunginsert/{idsupplier}", method = RequestMethod.POST, consumes = {"multipart/form-data", "application/json"})
    public ResponseEntity<Map> uploadFile(@RequestParam(value="file", required = true) MultipartFile file,  @PathVariable(value = "idsupplier") Long idsupplier,
                                          @RequestParam(value="nama", required = true) String nama,
                                          @RequestParam(value="stok", required = true) int stok,
                                          @RequestParam(value="satuan", required = true) String  satuan,
                                          @RequestParam(value="harga", required = true) int harga)  {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddMyyyyhhmmss");
        String strDate = formatter.format(date);
        String fileName = UPLOADED_FOLDER + strDate + file.getOriginalFilename();
        String fileNameforDOwnload = strDate + file.getOriginalFilename();
        Path TO = Paths.get(fileName);
        Map map = new HashMap();
        try {
            Files.copy(file.getInputStream(), TO); // pengolahan upload disini :
            // insert barang
            Barang b = new Barang();
            b.setNama(nama);
            b.setStok(stok);
            b.setSatuan(satuan);
            b.setHarga(harga);
            b.setFilenama(fileNameforDOwnload);
            map = servis.insert(b, idsupplier);
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
            return new ResponseEntity<Map>(map, HttpStatus.OK);
        }
        return new ResponseEntity<Map>(map, HttpStatus.OK);
    }

}
