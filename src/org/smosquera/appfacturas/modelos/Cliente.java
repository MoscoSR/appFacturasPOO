package org.smosquera.appfacturas.modelos;

public class Cliente {
    public Cliente () {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    private  String name;
    private String nif;

}
