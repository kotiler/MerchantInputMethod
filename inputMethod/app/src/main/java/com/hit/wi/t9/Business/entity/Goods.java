package com.hit.wi.t9.Business.entity;

//新闻头条所需要的实际数据
public class Goods {
    private String image_base64;
    private String name;
    private String price;
    private String description;

    public Goods(){
        this.image_base64="";
        this.name="";
        this.price="";
        this.description="";
    }

    public Goods(String image_base64, String name, String price, String description){
        this.image_base64=image_base64;
        this.name=name;
        this.price=price;
        this.description=description;
    }
    public String getName(){return name;}
    public String getDescription(){return description;}
    public String getPrice(){return price;}
    public String getImage_base64() {
        return image_base64;
    }
    public void setName(String name){this.name = name;}
    public void setDescription(String description){this.description = description;}
    public void setPrice(String price){this.price = price;}
    public void setImage_base64(String image_base64) {this.image_base64 = image_base64;}
    public void clear(){
        this.image_base64="";
        this.name="";
        this.price="";
        this.description="";
    }
    public boolean isEmpty(){
        return this.image_base64.equals("") && this.description.equals("") && this.name.equals("") && this.price.equals("");
    }
}




