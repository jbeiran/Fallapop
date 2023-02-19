package conexion;

import java.util.List;
import java.util.ArrayList;
import model.Chat;
import model.Producto;
import model.Vendedor;

public class Conexion {
    final static List<String> mensajesPrototipo = List.of(
        "Buenas ¿En que puedo ayudarle?",
        "El precio no es negociable.",
        "De acuerdo, cerramos el trato"
    );
    
    ArrayList<String> mensajesVendedor = new ArrayList<>();

    Vendedor vendedor;

    public Conexion(Vendedor vendedor) {
        this.vendedor = vendedor;
        mensajesVendedor.addAll(mensajesPrototipo);
    }

    public boolean recibirRespuesta(Chat chat){
        if(mensajesVendedor.isEmpty()) return false;

        String contenido = mensajesVendedor.get(0);
        mensajesVendedor.remove(0);

        chat.enviarMensaje(vendedor, contenido);

        return mensajesVendedor.isEmpty();
    }
}
