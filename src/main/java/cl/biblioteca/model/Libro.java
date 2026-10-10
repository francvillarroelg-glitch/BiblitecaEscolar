package cl.biblioteca.model;
public class Libro {
 private int id,stock,idCategoria; private String titulo,autor,isbn,editorial,categoria;
 public Libro(int id,String titulo,String autor,String isbn,String editorial,int stock,int idCategoria,String categoria){this.id=id;this.titulo=titulo;this.autor=autor;this.isbn=isbn;this.editorial=editorial;this.stock=stock;this.idCategoria=idCategoria;this.categoria=categoria;}
 public int getId(){return id;} public void setId(int v){id=v;} public String getTitulo(){return titulo;} public String getAutor(){return autor;} public String getIsbn(){return isbn;} public String getEditorial(){return editorial;} public int getStock(){return stock;} public int getIdCategoria(){return idCategoria;} public String getCategoria(){return categoria;}
 public void setTitulo(String v){titulo=v;} public void setAutor(String v){autor=v;} public void setIsbn(String v){isbn=v;} public void setEditorial(String v){editorial=v;} public void setStock(int v){stock=v;} public void setIdCategoria(int v){idCategoria=v;}
 @Override public String toString(){return titulo+" — stock: "+stock;}
}
