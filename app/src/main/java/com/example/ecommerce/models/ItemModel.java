package com.example.ecommerce.models;

public class ItemModel {
      Integer itemId ;
      Integer itemImage ;
      String itemTitle ;
      String itemType ;
      String itemPrice ;

    public ItemModel(Integer itemId, Integer itemImage, String itemTitle, String itemType, String itemPrice) {
        this.itemId = itemId;
        this.itemImage = itemImage;
        this.itemTitle = itemTitle;
        this.itemType = itemType;
        this.itemPrice = itemPrice;
    }


    public Integer getItemImage() {
        return itemImage;
    }

    public String getItemTitle() {
        return itemTitle;
    }

    public String getItemType() {
        return itemType;
    }

    public String getItemPrice() {
        return itemPrice;
    }


    public void setItemImage(Integer itemImage) {
        this.itemImage = itemImage;
    }

    public void setItemTitle(String itemTitle) {
        this.itemTitle = itemTitle;
    }

    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    public void setItemPrice(String itemPrice) {
        this.itemPrice = itemPrice;
    }
}
