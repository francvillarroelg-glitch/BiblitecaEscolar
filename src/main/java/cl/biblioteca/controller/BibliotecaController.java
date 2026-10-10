package cl.biblioteca.controller;
import cl.biblioteca.dao.*; import cl.biblioteca.model.*; import cl.biblioteca.service.PrestamoService; import java.sql.SQLException; import java.util.*;
/** Controlador MVC: coordina las vistas con los DAO y servicios. */
public class BibliotecaController {
 private final Usuario usuario; private final LibroDAO libros=new LibroDAO(); private final EstudianteDAO estudiantes=new EstudianteDAO(); private final CategoriaDAO categorias=new CategoriaDAO(); private final PrestamoDAO prestamos=new PrestamoDAO(); private final PrestamoService prestamoService=new PrestamoService();
 public BibliotecaController(Usuario u){usuario=u;} public Usuario getUsuario(){return usuario;} public boolean esBibliotecario(){return usuario.esBibliotecario();}
 public List<Libro> libros()throws SQLException{return libros.listar();} public List<Estudiante> estudiantes()throws SQLException{return estudiantes.listar();} public List<Categoria> categorias()throws SQLException{return categorias.listar();} public List<Prestamo> prestamos()throws SQLException{return prestamos.listar();} public List<Prestamo> activos()throws SQLException{return prestamos.activos();}
 public void guardarLibro(Libro l)throws SQLException{if(!esBibliotecario())throw new SecurityException("Solo bibliotecarios pueden administrar libros.");if(l.getStock()<0)throw new IllegalArgumentException("El stock no puede ser negativo.");if(l.getId()==0)libros.insertar(l);else libros.actualizar(l);}
 public void eliminarLibro(int id)throws SQLException{requireAdmin();libros.eliminar(id);} public void guardarEstudiante(Estudiante e)throws SQLException{requireAdmin();if(e.getId()==0)estudiantes.insertar(e);else estudiantes.actualizar(e);} public void eliminarEstudiante(int id)throws SQLException{requireAdmin();estudiantes.eliminar(id);}
 public java.util.concurrent.Future<?> registrarPrestamo(int e,int l){return prestamoService.registrarAsync(e,l);} public void devolver(int id)throws Exception{prestamoService.devolver(id);} public List<String> masPrestados()throws SQLException{return prestamos.masPrestados();} public List<String> historial(int id)throws SQLException{return prestamos.historial(id);}
 private void requireAdmin(){if(!esBibliotecario())throw new SecurityException("Función exclusiva del bibliotecario.");}
}
