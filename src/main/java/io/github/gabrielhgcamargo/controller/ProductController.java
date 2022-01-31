package io.github.gabrielhgcamargo.controller;

import io.github.gabrielhgcamargo.model.Market;
import io.github.gabrielhgcamargo.model.Product;
import io.github.gabrielhgcamargo.repository.ProductRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // SAVE PRODUCT
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Product save( @RequestBody Product product){
        return productRepository.save(product);
    }

    // UPDATE PRODUCT
    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Product product,
                       @PathVariable Integer id){
        productRepository
                .findById(id)
                .map(product1 -> {
                    product.setId(product1.getId());
                    productRepository.save(product);
                    return product;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found."));
    }

    // DELETE PRODUCT
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        productRepository
                .findById(id)
                .map(product -> {
                    productRepository.deleteById(id);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found."));
    }

    // GET PRODUCT
    @GetMapping("{id}")
    public Product update(@PathVariable Integer id){
        return productRepository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Product not found."));
    }

    @GetMapping
    public List<Product> find(Product filter){
        ExampleMatcher matcher = ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example example = Example.of(filter,matcher);
        return productRepository.findAll(example);
    }
}
