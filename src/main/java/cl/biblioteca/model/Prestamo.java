package cl.biblioteca.model;
import java.time.LocalDate;
public class Prestamo {
 private int id,idEstudiante,idLibro; private String estudiante,libro; private LocalDate fechaPrestamo,fechaDevolucion; private boolean devuelto;
 public Prestamo(int id,int idEstudiante,int idLibro,String estudiante,String libro,LocalDate fp,LocalDate fv,boolean devuelto){this.id=id;this.idEstudiante=idEstudiante;this.idLibro=idLibro;this.estudiante=estudiante;this.libro=libro;this.fechaPrestamo=fp;this.fechaDevolucion=fv;this.devuelto=devuelto;}
 public int getId(){return id;} public int getIdEstudiante(){return idEstudiante;} public int getIdLibro(){return idLibro;} public String getEstudiante(){return estudiante;} public String getLibro(){return libro;} public LocalDate getFechaPrestamo(){return fechaPrestamo;} public LocalDate getFechaDevolucion(){return fechaDevolucion;} public boolean isDevuelto(){return devuelto;} public boolean estaAtrasado(){return !devuelto && LocalDate.now().isAfter(fechaDevolucion);}
}
