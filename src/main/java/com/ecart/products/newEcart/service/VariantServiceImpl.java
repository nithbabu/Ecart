package com.ecart.products.newEcart.service;

import com.ecart.products.newEcart.model.Product;
import com.ecart.products.newEcart.model.Variant;
import com.ecart.products.newEcart.repo.EcartRepository;
import com.ecart.products.newEcart.repo.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class VariantServiceImpl implements VariantService{

    @Autowired
    private VariantRepository variantRepository;

    @Autowired
    private EcartRepository ecartRepository;

    @Override
    public void createVariant(Variant variant) {
        variantRepository.save(variant);
    }

    @Override
    public List<Product> getVariants(Variant variant) {
        String variantName = variant.getVariantName();
        String variantValue = variant.getVariantValue();
        if(variantName != null || variantValue != null) {
            List<Integer> idList = variantRepository.getData(variantName, variantValue);
            return ecartRepository.findAllById(idList);
        } else {
            return ecartRepository.findAll();
        }
    }

    @Override
    public Set<String> getVariantNames() {
        Set<String> variantNames = new TreeSet<>();
        variantNames = (Set<String>) variantRepository.getVariantNames();
        return variantNames;
    }
}
