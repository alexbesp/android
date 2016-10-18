package com.example.alexanderbespalov.activityresultexam.pojo;


public class PhoneModel {
    private long id;
    private String name;
    private long price;

    public PhoneModel(long id, String name, long price) {

        this.id = id;
        this.name = name;
        this.price = price;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getId() {

        return id;
    }

    public String getName() {
        return name;
    }

    public long getPrice() {
        return price;
    }


}
