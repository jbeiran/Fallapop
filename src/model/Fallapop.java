package model;

import java.util.ArrayList;

public class Fallapop {
    private Usuario usuarioLogeado = null;
    private ArrayList<Usuario> usuariosRegistrados = new ArrayList<>();
    private Catalogo catalogo;
    private ArrayList<CodigoDePromocion> codigosDePromocion;

    public Fallapop() {
        usuariosRegistrados.add(new Usuario("rubisrage", "Rubén Santana", "789472", "123", 100.0));
    }
    
    public boolean registrarUsuario(Usuario nuevoUsuario){
        for(Usuario usuario : usuariosRegistrados){
            if(usuario.getNombreDeUsuario().equals(nuevoUsuario.getNombreDeUsuario())){
                return false;
            }
        }

        usuariosRegistrados.add(nuevoUsuario);

        return iniciarSesion(nuevoUsuario.getNombreDeUsuario(), nuevoUsuario.getContr());
    }

    public boolean iniciarSesion(String nombreDeUsuario, String contr)
    {
        for(Usuario usuario : usuariosRegistrados){
            if(
                    usuario.getNombreDeUsuario().equals(nombreDeUsuario)
                    && usuario.getContr().equals(contr)
            ){
                usuarioLogeado = usuario;
                return true;
            }
        }

        return false;
    }

    public void cerrarSesion(){
        this.usuarioLogeado = null;
    }

    public Catalogo getCatalogo(){
        return this.catalogo;
    }

    public void setCatalogo(ArrayList<Producto> productos){
        this.catalogo = new Catalogo(productos);
    }

    public Usuario getUsuarioLogeado(){
        return usuarioLogeado;
    }

    public void setCodigosDePromocion(ArrayList<CodigoDePromocion> codigos){
        this.codigosDePromocion = codigos;
    }

    public Chat crearChat(){
        return new Chat();
    }
}
