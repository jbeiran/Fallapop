package model;

import java.util.ArrayList;

public class HistorialDeCompras {

    public ArrayList<Compra> compras;

    public HistorialDeCompras() {
        compras = new ArrayList<>();
    }

    public void addCompra(Compra c) {
        compras.add(c);
    }

    public void removeCompra(Compra c) {
        compras.remove(c);
    }

    public ArrayList<Compra> getCompras() {
        return compras;
    }

    public void setCompras(ArrayList<Compra> compras) {
        this.compras = compras;
    }
}
