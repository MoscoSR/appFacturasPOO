package org.smosquera.appfacturas.modelos;

public class Producto {
    public Producto() {
        this.code = ++ultimateCode;
    }


    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    private int  code;
    private String name;
    private float price;
    private static int ultimateCode;
}
