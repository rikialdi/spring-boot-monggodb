package com.binar.binar.controller.unittest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestTemplateUnitTestController {
    @Autowired
    private TestRestTemplate restTemplate;
//    https://github.com/uptech/spring-boot-rest-api-versioning-example/blob/master/src/test/java/com/example/HttpRequestTest.java

    @Test
    public void restTemplateSaveBarang() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "    \"nama\":\"barang 4\",\n" +
                "    \"stok\":\"10\",\n" +
                "    \"satuan\":\"pcs\",\n" +
                "    \"harga\":\"1000\",\n" +
                "    \"detailbrg\": {\n" +
                "        \"nama\":\"barang 4\"\n" +
                "    }\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<String>(bodyTesting, headers);

        Long idsupplier = 1L;
        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/api/v1/binar/save/"+idsupplier , HttpMethod.POST, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response save barang="+exchange.getBody());
//        assertEquals("application/vnd.example.v8+json", exchange.getHeaders().get("Content-Type").get(0));
//        assertEquals("{ \"accept\": \"application/vnd.example.v2+json\", \"content-type\": \"application/vnd.example.v2+json\", \"body\": \"{ \"test\": \"phil\" }\" }", exchange.getBody());
    }

    @Test
    public void restTemplateListBarang() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);

        ResponseEntity<String> exchange = restTemplate.exchange("http://localhost:8080/api/v1/binar/listpage" , HttpMethod.GET, entity, String.class);

        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response list barang="+exchange.getBody());
//        assertEquals("application/vnd.example.v8+json", exchange.getHeaders().get("Content-Type").get(0));
//        assertEquals("{ \"accept\": \"application/vnd.example.v2+json\", \"content-type\": \"application/vnd.example.v2+json\", \"body\": \"{ \"test\": \"phil\" }\" }", exchange.getBody());
    }
}
