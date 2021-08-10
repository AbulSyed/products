package com.syed.product.service;

import com.syed.product.entity.Product;
import com.syed.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Product product) {
        Product currentProduct = productRepository.findById(product.getId()).orElse(null);
        currentProduct.setName(product.getName());
        currentProduct.setQuantity(product.getQuantity());
        currentProduct.setPrice(product.getPrice());
        return productRepository.save(currentProduct);
    }
}