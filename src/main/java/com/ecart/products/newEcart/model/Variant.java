package com.ecart.products.newEcart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "variant", schema = "ecartschema")
public class Variant {

    @Id
    @Column(name = "id")
    public Integer id;

    @Column(name = "variantType")
    public String variantType;

    @Column(name = "variantName")
    public String variantName;

    @Column(name= "variantValue")
    public String variantValue;

    public String getVariantType() {
        return variantType;
    }

    public void setVariantType(String variantType) {
        this.variantType = variantType;
    }

    public String getVariantName() {
        return variantName;
    }

    public void setVariantName(String variantName) {
        this.variantName = variantName;
    }

    public String getVariantValue() {
        return variantValue;
    }

    public void setVariantValue(String variantValue) {
        this.variantValue = variantValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
