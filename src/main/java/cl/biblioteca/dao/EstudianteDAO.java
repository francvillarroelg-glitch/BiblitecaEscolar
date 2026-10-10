package cl.biblioteca.dao;
import cl.biblioteca.config.DatabaseConnection; import cl.biblioteca.model.Estudiante; import java.sql.*; import java.util.*;
public class EstudianteDAO implements CrudDAO<Estudiante> {
 public List<Estudiante> listar()throws SQLException{List<Estudiante>a=new ArrayList<>();try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("SELECT * FROM estudiantes ORDER BY nombre");ResultSet r=p.executeQuery()){while(r.next())a.add(new Estudiante(r.getInt("id"),r.getString("nombre"),r.getString("rut"),r.getString("curso"),r.getString("correo")));}return a;}
 public void insertar(Estudiante e)throws SQLException{try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("INSERT INTO estudiantes(nombre,rut,curso,correo) VALUES(?,?,?,?)")){fill(p,e);p.executeUpdate();}}
 public void actualizar(Estudiante e)throws SQLException{try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("UPDATE estudiantes SET nombre=?,rut=?,curso=?,correo=? WHERE id=?")){fill(p,e);p.setInt(5,e.getId());p.executeUpdate();}}
 private void fill(PreparedStatement p,Estudiante e)throws SQLException{p.setString(1,e.getNombre());p.setString(2,e.getRut());p.setString(3,e.getCurso());p.setString(4,e.getCorreo());}
 public void eliminar(int id)throws SQLException{try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM estudiantes WHERE id=?")){p.setInt(1,id);p.executeUpdate();}}
}
