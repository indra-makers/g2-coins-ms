package com.co.indra.coinmarketcap.coins.model.entities;

import java.io.Serializable;

public class Category implements Serializable {
    private Long idCategory;
    private String nameCategory;
    private String descriptionCategory;

    public Category() {
    }

    public Category(Long idCategory, String nameCategory, String descriptionCategory) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.descriptionCategory = descriptionCategory;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public String getDescriptionCategory() {
        return descriptionCategory;
    }

    public void setDescriptionCategory(String descriptionCategory) {
        this.descriptionCategory = descriptionCategory;
    }
}
