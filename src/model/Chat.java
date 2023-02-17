package model;

import java.util.ArrayList;

public class Chat {

    public ArrayList<Mensaje> mensajes;

    public Chat() {
        mensajes = new ArrayList<>();
    }

    public void addMensaje(Mensaje m) {
        mensajes.add(m);
    }

    public void removeMensaje(Mensaje m) {
        mensajes.remove(m);
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }   
}
