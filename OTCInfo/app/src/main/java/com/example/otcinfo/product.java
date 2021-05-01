package com.example.otcinfo;

import java.io.Serializable;

public class product implements Serializable {
    private drug d;
    private String type;
    private String price;
    private String totalWeigh;
    private String image;
    private String manufacturer;
    private String country;

    public product(drug dr, String t, String p, String tg, String i){
        d= dr;
        type= t;
        price= p;
        totalWeigh= tg;
        image= i;
    }

    public product(){
        d= null;    type= null;     price= null;
        totalWeigh= null;    image= null;
        manufacturer= null;     country= null;
    }

    //d methods
    public drug getD() { return d; }
    public void setD(drug d) { this.d = d; }

    //type methods
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    //price methods
    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }

    //total grams methods
    public String getTotalWeigh() { return totalWeigh; }
    public void setTotalWeigh(String totalGrams) { this.totalWeigh = totalGrams; }

    //image methods
    public String getImage() { return image; }
    public void setImage(String image) { this.image = image; }

    //manufacturer methods
    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    //country methods
    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

}