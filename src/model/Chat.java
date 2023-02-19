package model;

import java.util.List;
import java.util.ArrayList;
import java.time.LocalTime;

public class Chat {
    private ArrayList<Mensaje> mensajes = new ArrayList<>();

    public Chat() {}

    public void enviarMensaje(Persona emisor, String contenido){
        mensajes.add(new Mensaje(contenido, LocalTime.now(), emisor));
    }

    public List<Mensaje> getMensajes(){
        return mensajes;
    }
}
