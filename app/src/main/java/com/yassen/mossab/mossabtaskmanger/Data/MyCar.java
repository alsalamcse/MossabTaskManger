package com.yassen.mossab.mossabtaskmanger.Data;

public class MyCar {

    private String key;
    private String Tybe;
    private String price;
    private String Model;
    private String Color;
    private String Kilometerage;
    private String PhoneNumber;
    private String owner;
    private String Adrees;

    public MyCar()
    {

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTybe() {
        return Tybe;
    }

    public void setTybe(String tybe) {
        Tybe = tybe;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public String getKilometerage() {
        return Kilometerage;
    }

    public void setKilometerage(String kilometerage) {
        Kilometerage = kilometerage;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAdrees() {
        return Adrees;
    }

    public void setAdrees(String adrees) {
        Adrees = adrees;
    }

    @Override
    public String toString() {
        return "MyCar{" +
                "key='" + key + '\'' +
                ", Tybe='" + Tybe + '\'' +
                ", price='" + price + '\'' +
                ", Model='" + Model + '\'' +
                ", Color='" + Color + '\'' +
                ", Kilometerage='" + Kilometerage + '\'' +
                ", PhoneNumber='" + PhoneNumber + '\'' +
                ", owner='" + owner + '\'' +
                ", Adrees='" + Adrees + '\'' +
                '}';
    }
}
