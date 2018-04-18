package com.willstay.springbootetl.domain;

public class Truck implements AbstractCar{
    private String vin;
    private Integer milage;
    private String location;
    private Integer price; // kUsd
    private Integer maxWeight; // kg

    public Truck(String vin, Integer milage, String location, Integer price, Integer maxWeight) {
        this.vin = vin;
        this.milage = milage;
        this.location = location;
        this.price = price;
        this.maxWeight = maxWeight;
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

    public Integer getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Integer maxWeight) {
        this.maxWeight = maxWeight;
    }
}
