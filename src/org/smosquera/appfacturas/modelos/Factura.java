package org.smosquera.appfacturas.modelos;

import java.text.SimpleDateFormat;
import java.util.*;

public class Factura {

    public Factura(String description, Cliente cliente) {
        this.description = description;
        this.cliente = cliente;
        this.itemFacturas = new ItemFactura[MAX_ITEMS];
        this.folio = ultimoFolio++;
        this.date = new Date();
    }

    public int getFolio() {
        return folio;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Cliente cliente () {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ItemFactura[] getItemFacturas() {
        return itemFacturas;
    }

    public  void addItemFacture(ItemFactura itemFactura) {
        if(indexItems < MAX_ITEMS) {
            this.itemFacturas[indexItems++] = itemFactura;
        }
    }

    public  float calculateTotal() {
        float total = 0.0f;

        for (ItemFactura itemFactura : this.itemFacturas){
            if (itemFactura == null) {
                continue;
            }
            total+= itemFactura.calculateImport();
        }
        return total;
    }

    public String generateDetail() {
        StringBuilder stringBuilder = new StringBuilder("Factura N°: ");
        stringBuilder.append(folio)
                            .append("\nCliente: ")
                            .append(this.cliente.getName())
                .append("\t NIF: ")
                .append(cliente.getNif())
                .append(this.description)
                .append("\n")
                .append("\n#\tNombre\t$\tCant.\tTotal\n");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd 'de' MMM, YYYY");
         stringBuilder.append("Fecha Emision: ")
                 .append(simpleDateFormat.format(this.date))
                 .append("\n");

         for (ItemFactura item : this.itemFacturas) {
             if (item == null) {
                 continue;
             }
             stringBuilder.append(item.getProducto().getCode())
                     .append("\t")
                     .append(item.getProducto().getName())
                     .append("\t")
                     .append(item.getProducto().getPrice())
                     .append("\t")
                     .append(item.getAmount())
                     .append("\t")
                     .append(item.calculateImport())
                     .append("\t");
         }
         stringBuilder.append("\nGran Total: ")
                 .append(calculateTotal());

        return stringBuilder.toString();
    }

    private int folio;
    private String description;
    private Date date;
    private Cliente cliente;
    private ItemFactura[] itemFacturas;
    private int indexItems;
    public static final int MAX_ITEMS = 10;
    private int ultimoFolio;
}
