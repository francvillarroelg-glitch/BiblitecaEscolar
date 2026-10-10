package cl.biblioteca.dao;
import cl.biblioteca.config.DatabaseConnection; import cl.biblioteca.model.Categoria; import java.sql.*; import java.util.*;
public class CategoriaDAO {
 public List<Categoria> listar() throws SQLException {List<Categoria> out=new ArrayList<>();try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement("SELECT id,nombre FROM categorias ORDER BY nombre");ResultSet r=p.executeQuery()){while(r.next())out.add(new Categoria(r.getInt(1),r.getString(2)));}return out;}
}
