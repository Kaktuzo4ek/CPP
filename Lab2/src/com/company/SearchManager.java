package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchManager {

    private List<Drug> drug;

    public SearchManager(List<Drug> drug){
        this.drug = drug;
    }

    public List<Drug> findByType(String type){
        List<Drug> result = new ArrayList<>();
        for(Drug drug : drug){
            if (type.equals(drug.getType())){
                result.add(drug);
            }
        }
        return result;
    }

    public List<Drug> findByPrice(Float priceMin, Float priceMax){
        List<Drug> result = new ArrayList<>();
        for(Drug d : drug){
            if (priceMin < d.getPrice()&& priceMax > d.getPrice()){
                result.add(d);
            }
        }
        return result;
    }
}
