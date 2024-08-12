package com.osmanli_building.controller;

import com.osmanli_building.service.S3Service;
import com.osmanli_building.service.implementation.ProductServiceImplementation;
import com.osmanli_building.model.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductServiceImplementation productServiceImplementation;

    public ProductController(ProductServiceImplementation productServiceImplementation) {
        this.productServiceImplementation = productServiceImplementation;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productList = productServiceImplementation.findAllProducts();
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestParam("image") MultipartFile image,
                                              @RequestParam("name") String name,
                                              @RequestParam("description") String description,
                                              @RequestParam("price") int price,
                                              @RequestParam("totalProductsInStock") int totalProductsInStock) throws Exception {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setTotalProductsInStock(totalProductsInStock);

        return ResponseEntity.ok(productServiceImplementation.addProduct(product, image));
    }
}
