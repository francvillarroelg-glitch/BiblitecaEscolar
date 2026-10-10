package cl.biblioteca.model;

public class Usuario extends Persona {
    private String contrasena, rol;
    public Usuario(int id,String nombre,String rut,String correo,String contrasena,String rol){super(id,nombre,rut,correo);this.contrasena=contrasena;this.rol=rol;}
    public String getContrasena(){return contrasena;} public String getRol(){return rol;}
    public boolean esBibliotecario(){return "BIBLIOTECARIO".equalsIgnoreCase(rol);}
    @Override public String getTipoPersona(){return esBibliotecario()?"Bibliotecario":"Estudiante";}
}
