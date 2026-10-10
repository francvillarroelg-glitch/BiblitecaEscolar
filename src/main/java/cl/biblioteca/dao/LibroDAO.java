package cl.biblioteca.dao;
import cl.biblioteca.config.DatabaseConnection; import cl.biblioteca.model.Libro; import java.sql.*; import java.util.*;
public class LibroDAO implements CrudDAO<Libro> {
 private static final String SELECT="SELECT l.*,c.nombre categoria FROM libros l JOIN categorias c ON c.id=l.id_categoria";
 public List<Libro> listar() throws SQLException {List<Libro> a=new ArrayList<>();try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement(SELECT+" ORDER BY l.titulo");ResultSet r=p.executeQuery()){while(r.next())a.add(map(r));}return a;}
 private Libro map(ResultSet r)throws SQLException{return new Libro(r.getInt("id"),r.getString("titulo"),r.getString("autor"),r.getString("isbn"),r.getString("editorial"),r.getInt("stock"),r.getInt("id_categoria"),r.getString("categoria"));}
 public void insertar(Libro b)throws SQLException{String s="INSERT INTO libros(titulo,autor,isbn,editorial,stock,id_categoria) VALUES(?,?,?,?,?,?)";try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement(s)){fill(p,b);p.executeUpdate();}}
 public void actualizar(Libro b)throws SQLException{String s="UPDATE libros SET titulo=?,autor=?,isbn=?,editorial=?,stock=?,id_categoria=? WHERE id=?";try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement(s)){fill(p,b);p.setInt(7,b.getId());if(p.executeUpdate()==0)throw new SQLException("No se encontró el libro seleccionado.");}}
 private void fill(PreparedStatement p,Libro b)throws SQLException{p.setString(1,b.getTitulo());p.setString(2,b.getAutor());p.setString(3,b.getIsbn());p.setString(4,b.getEditorial());p.setInt(5,b.getStock());p.setInt(6,b.getIdCategoria());}
 public void eliminar(int id)throws SQLException{try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("DELETE FROM libros WHERE id=?")){p.setInt(1,id);p.executeUpdate();}}
 public synchronized void cambiarStock(Connection c,int id,int delta)throws SQLException{try(PreparedStatement p=c.prepareStatement("UPDATE libros SET stock=stock+? WHERE id=? AND stock+?>=0")){p.setInt(1,delta);p.setInt(2,id);p.setInt(3,delta);if(p.executeUpdate()!=1)throw new SQLException("Stock insuficiente o libro inexistente.");}}
}
