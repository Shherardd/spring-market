package com.shd.market.domain.service;

import com.shd.market.domain.Product;
import com.shd.market.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productrepository;

    public List<Product> getAll(){
        return productrepository.getAll();
    }

    public Optional<Product> getProduct(int productId){
        return productrepository.getProduct(productId);
    }

    public Optional<List<Product>> getByCategory(int categoryId) {
        return productrepository.getByCategory(categoryId);
    }

    public Product save(Product product){
        return productrepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(product -> {
            productrepository.delete(productId);
           return true;
        }).orElse(false);
    }

}
