package cl.biblioteca.dao;
import java.sql.SQLException; import java.util.List;
public interface CrudDAO<T> { List<T> listar() throws SQLException; void insertar(T objeto) throws SQLException; void actualizar(T objeto) throws SQLException; void eliminar(int id) throws SQLException; }
