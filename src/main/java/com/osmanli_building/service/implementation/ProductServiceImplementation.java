package com.osmanli_building.service.implementation;

import com.osmanli_building.model.Product;
import com.osmanli_building.repository.ProductRepository;
import com.osmanli_building.service.ProductService;
import com.osmanli_building.service.S3Service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final S3Service s3Service;

    public ProductServiceImplementation(ProductRepository productRepository, S3Service s3Service) {
        this.productRepository = productRepository;
        this.s3Service = s3Service;
    }

    @Override
    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product addProduct(Product product, MultipartFile image) throws Exception {
        // Correct: Image upload should be handled here in the service layer
        String imageUrl = s3Service.uploadFile(image);
        product.setImageUrl(imageUrl);

        return productRepository.save(product);
    }
}
