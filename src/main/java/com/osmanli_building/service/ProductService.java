package com.osmanli_building.service;

import com.osmanli_building.model.Product;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ProductService {
    List<Product> findAllProducts();
    Product addProduct(Product product, MultipartFile image) throws Exception;
}

