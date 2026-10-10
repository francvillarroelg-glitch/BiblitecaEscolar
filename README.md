# Sistema de Gestión de Biblioteca Escolar

Aplicación de escritorio Java Swing para administrar libros, estudiantes, préstamos, devoluciones y reportes. Arquitectura MVC, DAO, Singleton JDBC, herencia/polimorfismo y ejecución de préstamos en segundo plano con sincronización.

## Requisitos
- JDK 17 o superior
- IntelliJ IDEA (o IDE compatible con Maven)
- MySQL 8+

## Instalación
1. Inicia MySQL.
2. Ejecuta `sql/01_crear_base_datos.sql` y luego `sql/02_datos_prueba.sql` en MySQL Workbench o consola.
3. Abre la carpeta del proyecto en IntelliJ IDEA como proyecto Maven y espera a que descargue MySQL Connector/J.
4. Configura la conexión mediante variables de entorno `BIBLIOTECA_DB_URL`, `BIBLIOTECA_DB_USER` y `BIBLIOTECA_DB_PASSWORD`, o edita los valores por defecto en `config/DatabaseConnection.java`.
5. Ejecuta `cl.biblioteca.Main`.

Conexión por defecto: `jdbc:mysql://localhost:3306/biblioteca_escolar?serverTimezone=America/Santiago&useSSL=false&allowPublicKeyRetrieval=true`, usuario `root`, contraseña vacía. Ajusta esto a tu instalación.

## Usuarios de prueba
- Bibliotecario: `admin@biblioteca.cl` / `admin123`
- Estudiante: `estudiante@biblioteca.cl` / `est123`

Las contraseñas de demostración se almacenan como texto simple para que el ejemplo sea fácil de ejecutar en contexto académico; no debe hacerse así en un sistema real. La aplicación valida rol y habilita o restringe opciones según corresponda.

## Funcionalidades
- Inicio de sesión por rol.
- CRUD de libros y estudiantes.
- Consulta de inventario y categorías.
- Registro de préstamos en un `SwingWorker`, con actualización de stock y operación sincronizada.
- Registro de devoluciones y detección de atrasos.
- Reportes de libros más prestados, historial de un estudiante y préstamos activos.

## Entrega
Incluye el código fuente y scripts SQL. Antes de entregar, prueba la conexión en tu equipo, graba el video de 3 a 5 minutos mostrando el sistema, el código, tu rostro y la explicación de MVC, DAO, Singleton, concurrencia y sincronización. Publica el proyecto en un repositorio público de GitHub y pega su enlace en AVA.
