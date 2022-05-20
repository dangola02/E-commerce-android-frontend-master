package com.example.ecommerce.models;

public class CateigoriesModel {
    String categoryTitle ;
    Integer categoryImg ;
    Integer categoryId ;

    public CateigoriesModel(Integer categoryId  ,String categoryTitle, Integer categoryImg) {
        this.categoryTitle = categoryTitle;
        this.categoryImg = categoryImg;
        this.categoryId = categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public Integer getCategoryImg() {
        return categoryImg;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setCategoryImg(Integer categoryImg) {
        this.categoryImg = categoryImg;
    }
}
