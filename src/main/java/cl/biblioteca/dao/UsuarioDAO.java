package cl.biblioteca.dao;
import cl.biblioteca.config.DatabaseConnection; import cl.biblioteca.model.Usuario; import java.sql.*;
public class UsuarioDAO {
 public Usuario autenticar(String login,String password) throws SQLException {
  String sql="SELECT * FROM usuarios WHERE (correo=? OR rut=?) AND contrasena=?";
  try(Connection c=DatabaseConnection.getInstance().getConnection();PreparedStatement p=c.prepareStatement(sql)){p.setString(1,login);p.setString(2,login);p.setString(3,password);try(ResultSet r=p.executeQuery()){if(r.next())return new Usuario(r.getInt("id"),r.getString("nombre"),r.getString("rut"),r.getString("correo"),r.getString("contrasena"),r.getString("rol"));return null;}}
 }
}
