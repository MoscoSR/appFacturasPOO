package org.smosquera.appfacturas;
import org.smosquera.appfacturas.modelos.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.setNif("555-5");
        cliente.setName("Andres");


        Scanner input = new Scanner(System.in);
        System.out.println("Ingresa descripcion de la factura: ");
        String desc = input.nextLine();

        Factura factura = new Factura(desc,cliente);

        Producto producto;
        String nombre;
        float price;
        int amount;

        System.out.println();

        for(int i = 0; i<5; i++) {
            producto = new Producto();
            System.out.print("Ingrese producto: " + producto.getCode() + ": ");
            nombre = input.nextLine();
            producto.setName(nombre);

            input.nextLine();

            System.out.print("Ingresa el precio del producto:  ");
            price = input.nextFloat();
            producto.setPrice(price);



            System.out.print("Ingresa la cantidad del producto");
            amount = input.nextInt();

            ItemFactura itemFactura = new ItemFactura(amount, producto);
            factura.addItemFacture(itemFactura);

            System.out.println();
        }
        System.out.println(factura.generateDetail());
    }
}
