package org.smosquera.appfacturas.modelos;

import org.smosquera.appfacturas.modelos.Producto;

public class ItemFactura {

    public ItemFactura(int amount, Producto producto) {
        this.amount = amount;
        this.producto = producto;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public float calculateImport() {
        return this.amount*this.producto.getPrice();
    }



    private int  amount;
    private Producto producto;


}
