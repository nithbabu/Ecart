package com.ecart.products.newEcart.service;

import com.ecart.products.newEcart.model.Product;
import com.ecart.products.newEcart.repo.EcartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface ProductService {

    public List<Product> getProducts();

    public void postProduct(Product product);
    public void updateProduct(Product product);
    public Product getProduct(Integer productId);
    public void deleteProduct(Integer productId);

}
