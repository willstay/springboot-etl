package com.willstay.springbootetl.domain;

public class Suv implements AbstractCar {
    private String vin;
    private Integer milage;
    private String location;
    private Integer price; // kUsd

    public Suv(String vin, Integer milage, String location, Integer price) {
        this.vin = vin;
        this.milage = milage;
        this.location = location;
        this.price = price;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public Integer getMilage() {
        return milage;
    }

    public void setMilage(Integer milage) {
        this.milage = milage;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
