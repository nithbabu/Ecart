package com.ecart.products.newEcart.service;

import com.ecart.products.newEcart.model.Product;
import com.ecart.products.newEcart.model.Variant;

import java.util.List;
import java.util.Set;

public interface VariantService {

    public void createVariant(Variant variant);

    public List<Product> getVariants(Variant variant);

    public Set<String> getVariantNames();

}
