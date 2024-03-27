package com.example.myapplication;

public class Item {

    String name;
    String descp;
    int image;

    public Item(String name, String descp, int image) {
        this.name = name;
        this.descp = descp;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
