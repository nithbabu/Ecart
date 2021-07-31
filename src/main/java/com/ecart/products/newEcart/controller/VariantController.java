package com.ecart.products.newEcart.controller;

import com.ecart.products.newEcart.model.Variant;
import com.ecart.products.newEcart.service.VariantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VariantController {

    public static final String VAR_INDEX = "/update/create-variant/{id}";
    public static final String VAR_INDEX_VIEW = "create-product/create-variant/form";

    @Autowired
    private VariantService variantService;

    @GetMapping(VAR_INDEX)
    public String getIndex(@PathVariable("id") Integer prodId, ModelMap modelMap) {
        Variant variant = new Variant();
        modelMap.addAttribute("productId", prodId);
        modelMap.addAttribute("variant", variant);
        return VAR_INDEX_VIEW;
    }

    @PostMapping(VAR_INDEX)
    public String createVariant(Variant variant) {
        variantService.createVariant(variant);
        return "redirect:/dashboard";
    }
}
