package com.binar.binar.service.impl;

import com.binar.binar.entity.Barang;
import com.binar.binar.entity.BarangDetail;
import com.binar.binar.entity.Supplier;
import com.binar.binar.service.BarangRestTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //service wajib
@Transactional // opsional :
public class BarangRestTemplateImpl implements BarangRestTemplateService {

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;


    @Override
    public Map insert(Barang barang, Long idsupplier) {
        Map map = new HashMap();
        try {
            String url = "http://localhost:8080/api/v1/binar/save/"+idsupplier;

            ResponseEntity<Map> result = restTemplateBuilder.build().postForEntity(url, barang, Map.class);


            map.put("data", result.getBody());
            map.put("statusCode", "200");
            map.put("statusMessage", "Sukses");
            return map;// respon

        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;
        }
    }

    @Override
    public Map update(Barang barang, Long idsupplier) {
//        https://www.baeldung.com/rest-template
//        https://github.com/raviyasas/SpringBoot-RestTemplate-demo/blob/master/src/main/java/com/app/demo/service/ApiService.java
        return null;
    }

    @Override
    public Map delete(Barang barang) {
//        https://github.com/raviyasas/SpringBoot-RestTemplate-demo/blob/master/src/main/java/com/app/demo/service/ApiService.java
        return null;
    }

    @Override
    public Map getData() {
        List<Barang> list = new ArrayList<Barang>();
        Map map = new HashMap();
        try {

            String url = "http://localhost:8080/api/v1/binar/listpage";

            ResponseEntity<Map> result = restTemplateBuilder.build().
                    exchange(url,
                            HttpMethod.GET, null, new ParameterizedTypeReference<Map>() {});


            map.put("data", result.getBody());//data
            map.put("statusCode", 200);
            map.put("statusMessage", "Get Sukses");
            return map;//success
        } catch (Exception e) {
            e.printStackTrace();
            map.put("statusCode", "500");
            map.put("statusMessage", e);
            return map;// eror
        }
    }

//    public User patchData(User requestUser, Long id) {
//
//        String url = "http://localhost:8090/api/user/patchUser/" + id;
//
//        Object result = restTemplateBuilder.build().patchForObject(url, requestUser, User.class);
//
//        User user = new User();
//
//        if(result != null) {
//            if (requestUser.getName() != null) {
//                user.setName(((User) result).getName());
//            }
//            if (requestUser.getEmail() != null) {
//                user.setEmail(((User) result).getEmail());
//            }
//        }
//        return user;
//    }

//    public void deleteData(Long id) {
//
//        String url = "http://localhost:8090/api/user/deleteUser/" + id;
//
//        try{
//            restTemplateBuilder.build().delete(url);
//        }catch (Exception e){
//            e.getMessage();
//        }
//    }
}
