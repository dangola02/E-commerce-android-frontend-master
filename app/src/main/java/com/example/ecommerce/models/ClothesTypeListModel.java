package com.example.ecommerce.models;

public class ClothesTypeListModel {
    String clothesTypeName ;
    Integer clothersTypeId ;

    public ClothesTypeListModel(String clothesTypeName, Integer clothersTypeId) {
        this.clothesTypeName = clothesTypeName;
        this.clothersTypeId = clothersTypeId;
    }

    public Integer getClothersTypeId() {
        return clothersTypeId;
    }

    public String getClothesTypeName() {
        return clothesTypeName;
    }

    public void setClothesTypeName(String clothesTypeName) {
        this.clothesTypeName = clothesTypeName;
    }

    public void setClothersTypeId(Integer clothersTypeId) {
        this.clothersTypeId = clothersTypeId;
    }
}
