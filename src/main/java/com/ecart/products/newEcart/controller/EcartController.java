package com.ecart.products.newEcart.controller;

import com.ecart.products.newEcart.model.Product;
import com.ecart.products.newEcart.model.Variant;
import com.ecart.products.newEcart.service.ProductService;
import com.ecart.products.newEcart.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EcartController {
    public static final String INDEX = "/dashboard";
    public static final String INDEX_VIEW = "index";
    public static final String CREATE = "/create-product";
    public static final String CREATE_VIEW = "create-product/form";
    public static final String UPDATE = "/update/{id}";
    public static final String DELETE = "/delete/{id}";
    public static final String FILTER = "/dashboard/filter";

    @Autowired
    private ProductService productService;

    @Autowired
    private VariantService variantService;

    @GetMapping("/")
    public String redirectToIndex() {
        return "redirect:" + INDEX;
    }

    @GetMapping(INDEX)
    public String index(ModelMap modelMap) {
        modelMap.addAttribute("products", productService.getProducts());
        modelMap.addAttribute("variantNames", variantService.getVariantNames());
        return INDEX_VIEW;
    }

    @GetMapping(CREATE)
    public String getView(ModelMap modelMap) {
        Product product = new Product();
        modelMap.addAttribute("product", product);
        return CREATE_VIEW;
    }

    @PostMapping(CREATE)
    public String create(Product product) {
        productService.postProduct(product);
        return "redirect:" + INDEX;
    }

    @GetMapping(UPDATE)
    public String getUpdate(@PathVariable("id") Integer prodId, ModelMap modelMap) {
        modelMap.addAttribute("productId", prodId);
        modelMap.addAttribute("product", productService.getProduct(prodId));
        return CREATE_VIEW;
    }

    @PostMapping(UPDATE)
    public String postUpdate(Product product, ModelMap modelMap) {
        productService.updateProduct(product);
        return "redirect:" + INDEX;
    }

    @GetMapping(DELETE)
    public String delete(@PathVariable("id") Integer prodId) {
        productService.deleteProduct(prodId);
        return "redirect:" + INDEX;
    }

    @GetMapping(FILTER)
    public String filter(Variant variant, ModelMap modelMap) {
        List<Product> productList = variantService.getVariants(variant);
        modelMap.addAttribute("products", productList);
        return INDEX_VIEW;
    }
}
