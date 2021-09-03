package com.binar.binar.praktek.restapi2;

import com.binar.binar.praktek.restapi.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/v1/mhs/")
public class MhsController {
    // list data
    private static Map<String, Mhs> mhsRepo = new HashMap<>();
    // wajib static: set value data
    static {
        // DI depedency injection ( Ioc)
        Mhs mhs1 = new Mhs();
        mhs1.setNama("nama 1");
        mhs1.setNim("1");

        mhsRepo.put(mhs1.getNim(), mhs1);

        Mhs mhs2 = new Mhs();
        mhs2.setNama("nama 2");
        mhs2.setNim("2");

        mhsRepo.put(mhs2.getNim(), mhs2);
    }
    // step 2
    @RequestMapping(value = "/")
    public ResponseEntity<Object> getMhs() {
        return new ResponseEntity<>(mhsRepo.values(), HttpStatus.OK);
    }

    // simpan step 3
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<Object> createMhs(@RequestBody Mhs mhs) {
        mhsRepo.put(mhs.getNim(), mhs);
        return new ResponseEntity<>("Mhs is created successfully", HttpStatus.CREATED);
    }
    // step 4 ubah data
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateMhs(@PathVariable("id") String nim, @RequestBody Mhs mhs) {
        mhsRepo.remove(nim);
        mhs.setNim(nim);
        mhsRepo.put(nim, mhs);
        return new ResponseEntity<>("Mhs is updated successsfully", HttpStatus.OK);
    }
    // step 5 delete
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") String id) {
        mhsRepo.remove(id);
        return new ResponseEntity<>("Mhs is deleted successsfully", HttpStatus.OK);
    }



    @Bean
    public String iniBean(){
        return "ini adalah bean";
    }





}
