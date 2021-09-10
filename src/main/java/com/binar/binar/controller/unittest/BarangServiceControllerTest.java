package com.binar.binar.controller.unittest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.binar.binar.entity.Barang;
import com.binar.binar.model.ModelBarang;
import com.binar.binar.repository.BarangRepo;
import com.binar.binar.service.BarangService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Collections;
import java.util.List;
import java.util.Map;


public class BarangServiceControllerTest extends UnitTest{

    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Autowired
    public BarangService serviceBarang;

    @Autowired
    public BarangRepo repo;

    @Test
    public void getProductsList() throws Exception {
        //call appi localhost
        String uri = "/v1/binar/listpage";
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get(uri)
                .accept(MediaType.APPLICATION_JSON_VALUE)).andReturn();

        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
        String content = mvcResult.getResponse().getContentAsString();
        System.out.println("Response=");
        System.out.println(content);
//        ModelBarang[] productlist =   super.mapFromJson(content, ModelBarang[].class);
//        assertTrue(productlist.length > 0);
    }

    @Test
    public void count() throws Exception {
         Long count = repo.count();
         System.out.println("total ="+count);
    }

    @Test
    public void dtoModel() throws Exception {
        List<ModelBarang> count = repo.modelDTO();
        System.out.println("total ="+count);
        for(ModelBarang a : count){
            System.out.println("nama="+a.getNama());
        }
    }

    @Test
    public void getbyNamaNative() throws Exception {
       Object[] obj = repo.getbyNamaNative("webbinar 10");
        System.out.println("getbyNamaNative ="+obj);
    }

    @Test
    public void getDataAllNative() throws Exception {
        List<Object[]> obj = repo.getDataAllNative();
        for (Object[] s_detail : obj) {
            System.out.println("id ="+s_detail[0] + " nama="+s_detail[1]);
            ModelBarang dto = new ModelBarang(Long.parseLong(s_detail[0].toString()),s_detail[1].toString());
        }
    }


}
