USE biblioteca_escolar;
INSERT IGNORE INTO usuarios(nombre,rut,correo,contrasena,rol) VALUES
('Bibliotecario Demo','11.111.111-1','admin@biblioteca.cl','admin123','BIBLIOTECARIO'),
('Estudiante Demo','22.222.222-2','estudiante@biblioteca.cl','est123','ESTUDIANTE');
INSERT IGNORE INTO estudiantes(nombre,rut,curso,correo) VALUES
('Estudiante Demo','22.222.222-2','2° Medio A','estudiante@biblioteca.cl'),
('Camila Rojas','23.456.789-0','1° Medio B','camila@colegio.cl'),
('Diego Pérez','21.345.678-9','3° Medio A','diego@colegio.cl');
INSERT IGNORE INTO categorias(nombre) VALUES ('Literatura'),('Ciencias'),('Historia'),('Tecnología');
INSERT IGNORE INTO libros(titulo,autor,isbn,editorial,stock,id_categoria)
SELECT 'Cien años de soledad','Gabriel García Márquez','9780307474728','Sudamericana',5,id FROM categorias WHERE nombre='Literatura';
INSERT IGNORE INTO libros(titulo,autor,isbn,editorial,stock,id_categoria)
SELECT 'Breve historia del tiempo','Stephen Hawking','9780553380163','Bantam',3,id FROM categorias WHERE nombre='Ciencias';
INSERT IGNORE INTO libros(titulo,autor,isbn,editorial,stock,id_categoria)
SELECT 'La historia del mundo','Varios autores','9780000000001','Escolar',4,id FROM categorias WHERE nombre='Historia';
