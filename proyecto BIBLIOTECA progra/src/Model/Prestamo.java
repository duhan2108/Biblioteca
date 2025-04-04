package Model;

import java.time.*;
import java.time.format.DateTimeFormatter;
/** 
 *  Esta clase Prestamo está creada para representar un prestamo
 * 
 *  @author duhan olarte 
 */
public class Prestamo {
    /**Usuario de tipo usuario */
    private Usuario usuario;
    /**libro de tipo libro*/
    private Libro libro;
    /**fecha de préstamo*/
    private LocalDateTime fechaPrestamo;
   /*  fecha de devolución */
    private LocalDateTime fechaDevolucion;
    
/**
 * metodo constructor
 * @param usuario usuario
 * @param libro libro 
 * @param fechaPrestamo fecha de prestamo 
 * @param fechaDevolucion fecha de devolucion
 */
    public Prestamo(Usuario usuario, Libro libro, LocalDateTime fechaPrestamo, LocalDateTime fechaDevolucion) {
        this.usuario = usuario;
        this.libro = libro;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
    } 
    /** 
     * @return el  usuario del prestamo*/
    public Usuario getUsuario() {
        return usuario;
    }
    /**este metodo cambia la informacion usuario
     *  @param usuario informacion usuario*/
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /** @return el  libro del prstamo */
    public Libro getLibro() {
        return libro;
    }
     /**este metodo cambia la informacion del libro
     *  @param libro  informacion libro*/
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /** @return la fecha del prestamo*/
    public LocalDateTime getFechaPrestamo() {
        return fechaPrestamo;
    }
    /**este metodo cambia la fecha prestamo
     *  @param fechaPrestamo la fecha que se presto el libro*/
    public void setFechaPrestamo(LocalDateTime fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    /** @return la fecha de devolucion del libro */
    public LocalDateTime getFechaDevolucion() {
        return fechaDevolucion;
    }
    /**este metodo cambia la fecha de devolucion 
     *  @param fechaDevolucion la fecha de devolucion*/
    public void setFechaDevolucion(LocalDateTime fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
   /**
     * método muestra toda la información de libro
     */
    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
        String devolucion = fechaDevolucion.format(formato);
        String prestamo = fechaPrestamo.format(formato);
        return "usuario:" + usuario.getNombre()+" "+ usuario.getCedula()+ " libro :" + libro.getTitulo() + " Prestamo: " +prestamo + " Devolucion: " + devolucion +"\n";
    }

    

    
    
}

