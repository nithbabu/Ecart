package com.ecart.products.newEcart.service;

import com.ecart.products.newEcart.model.Product;
import com.ecart.products.newEcart.repo.EcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private EcartRepository ecartRepository;

    @Override
    public List<Product> getProducts() {
        return ecartRepository.findAll();
    }

    @Override
    public void postProduct(Product product) {
        ecartRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) {
        ecartRepository.save(product);
    }

    @Override
    public Product getProduct(Integer productId) {
        return ecartRepository.getById(productId);
    }

    @Override
    public void deleteProduct(Integer productId) {
        ecartRepository.deleteById(productId);
    }
}
