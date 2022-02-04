package io.github.gabrielhgcamargo.controller;

import io.github.gabrielhgcamargo.model.products.Body;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/test")
public class ProductTesteController {

    @Value("${api.key}")
    private String apiKey;

    @Value("${url.api.upc}")
    private String urlApi;

    @GetMapping("/{upc}")
    public Body getInfoProduct(@PathVariable String upc){

        RestTemplate restTemplate = new RestTemplate();

        StringBuilder builder = new StringBuilder();
        String finalUrl = builder
                .append(urlApi)
                .append(upc)
                .append("?apiKey=")
                .append(apiKey)
                .toString();

        ResponseEntity<Body> entity = restTemplate.getForEntity(finalUrl, Body.class);


        System.out.println(entity.getBody().getTitle());
        return entity.getBody();
    }

}
