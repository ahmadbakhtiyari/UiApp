package com.example.uichallenge.model;

public class ItemModel {
    int img_url;
    String Description , Price;

    public int getImg_url() {
        return img_url;
    }

    public void setImg_url(int img_url) {
        this.img_url = img_url;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public ItemModel(int img_url, String description, String price) {
        this.img_url = img_url;
        Description = description;
        Price = price;
    }
}
