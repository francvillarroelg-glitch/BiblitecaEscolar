package cl.biblioteca.service;
import cl.biblioteca.dao.PrestamoDAO; import java.util.concurrent.*;
/** Ejecuta las operaciones de circulación fuera del hilo de interfaz. */
public class PrestamoService {
 private final PrestamoDAO dao=new PrestamoDAO(); private final ExecutorService executor=Executors.newSingleThreadExecutor(r->{Thread t=new Thread(r,"prestamos-biblioteca");t.setDaemon(true);return t;});
 public Future<?> registrarAsync(int estudiante,int libro){return executor.submit(()->{try{dao.registrar(estudiante,libro);}catch(Exception e){throw new CompletionException(e);}});}
 public void devolver(int prestamo)throws Exception{dao.devolver(prestamo);}
 public void cerrar(){executor.shutdown();}
}
