package com.hai.appproject;

public class Upload {
    String name,mobile,price,available,url;
    Upload()
    {

    }

    public Upload(String name, String mobile, String price, String available, String url) {
        this.name = name;
        this.mobile = mobile;
        this.price = price;
        this.available = available;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPrice() {
        return price;
    }

    public String getAvailable() {
        return available;
    }

    public String getUrl() {
        return url;
    }
}
