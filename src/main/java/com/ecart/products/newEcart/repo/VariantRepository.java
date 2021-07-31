package com.ecart.products.newEcart.repo;

import com.ecart.products.newEcart.model.Variant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface VariantRepository extends JpaRepository<Variant, Integer> {

    @Query(value = "SELECT id FROM ecartschema.variant WHERE variant_name= ?1 and variant_value= ?2", nativeQuery = true)
    List<Integer> getData(String variantName, String variantValue);

    @Query(value = "SELECT variant_name FROM ecartschema.variant", nativeQuery = true)
    Set<String> getVariantNames();
}
