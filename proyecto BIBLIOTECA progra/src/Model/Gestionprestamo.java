package Model;

import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
/**
 *Esta clase gestiónpréstamo está creada para manipular todo lo que tiene que ver con préstamos{@link Prestamo}
 * @author Duhan olarte 
 * @author jorge maldonado
 */

public class Gestionprestamo {
    /**
     * creo lista de la clase préstamo , usuario , libro
     */
    private ArrayList<Prestamo> listaPrestamos;
    private ArrayList<Usuario> listaUsuarios;
    private ArrayList<Libro> listaLibros;
    
/**
 * metdodo Constructor que  recibe un objeto de gestiónlibro y un objeto de gestión usuario
 * Para poder utilizar el getter y asignárselos a las nuevas listas
 * @param gestionlibro Objeto de tipo Gestionlibro 
 * @param gestionUsuario Objeto de tipo GestiónUsuario
 */

    public Gestionprestamo( GestionLibro gestionlibro , GestionUsuario gestionUsuario) {
         this.listaLibros = gestionlibro.getListaLibros();
        this.listaPrestamos = new ArrayList<Prestamo>();
        this.listaUsuarios = gestionUsuario.getListaUsuarios();

    }

    /**
     * Método que realiza un prestamo 
     * @param cedula Cédula el solicitante
     * @param isbn ISBN del libro solicitado
     * @return Si el usuario está en la listade usuarios , el libro enla lista de libros y hay cantidad suficiente de estos 
     * retornara Mensaje de confirmación libro prestado y la fecha de devolución 
     * si no encuentra el usuario ni el libro o no hay  retornara eror
     */
    public String realizarPrestamo(String cedula, String isbn) {
        String solicitud = "";
        Usuario solicitante = null;
        Libro libroSolicitado = null;
        int librosDisponibles = 0;

        for (Usuario usuarioaux : listaUsuarios) {
            if (usuarioaux.getCedula().equals(cedula)) {
                solicitante = usuarioaux;
                break;
            } 
                
            }

            if ( solicitante == null){
                return  "usuario no encontrado";
            }
        
        for (Libro libroaux : listaLibros) {
            if (libroaux.getIsbn().equals(isbn)) {
                libroSolicitado = libroaux;
            } 
               
            }

            if (libroSolicitado== null){
                return"libro no encontrado";
            }
        
        if (libroSolicitado.getcantidad() <= 0) {
            return "no hay ejemplares del libro disponibles actualmente en la biblioteca";
        
        } 

              librosDisponibles = (libroSolicitado.getcantidad()-1);
            libroSolicitado.setcantidad(librosDisponibles);
        
        LocalDateTime fechaSolicitud = LocalDateTime.now();
        LocalDateTime fechaEntrega = fechaSolicitud.plusMinutes(1);

        
            this.listaPrestamos.add(new Prestamo(solicitante, libroSolicitado, fechaSolicitud, fechaEntrega));
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy  HH:mm:ss");
             String fechaFormateada = fechaEntrega.format(formato);

            solicitud = " usuario " + solicitante.getNombre() + "  libro" + libroSolicitado.getTitulo()+ " Debe entregar en la fecha" +fechaFormateada;
        
        return solicitud;
    }
   /**
    * Este método es el encargadode hacer la devolución del libro por cédula  y ISN
    * @param cedula Cédula del usuario que devuelve el libro
    * @param isbn ISBN del libro a ser devuelto
    * @return  Sí la cédula del usuario está bien Y el ISBN también , retornará mensaje de confirmación ,Pero si la fecha de entregaes después
    De la fechaDevolucion entoces entrega tarde
    * Si no retornará mensaje de error
    */
    public String realizarDevolucion(String cedula, String isbn) {
        String devolucionlibro = "";
        Usuario solicitante = null;
        Libro libroPrestado = null;
        for (Usuario usuarioaux : listaUsuarios) {
            if (usuarioaux.getCedula().equals(cedula)) {
                solicitante = usuarioaux;
                for (Libro libroaux : listaLibros) {
                    if (libroaux.getIsbn().equals(isbn)) {
                        libroPrestado = libroaux;
                        libroPrestado.setcantidad(libroPrestado.getcantidad() + 1);
                        for (Prestamo prestamoaux : listaPrestamos) {
                            if (prestamoaux.getUsuario().equals(usuarioaux)
                                    && prestamoaux.getLibro().equals(libroaux)) {
                                 LocalDateTime fechaentregado = LocalDateTime.now();
                                

                                devolucionlibro = "el libro  " + libroPrestado.toString()
                                        + "  ha sido devuelto a la biblioteca por el usuario " + solicitante.getNombre() ;

                                if (fechaentregado .isAfter(prestamoaux.getFechaDevolucion())) {
                                    devolucionlibro = devolucionlibro +"\n"+
                                     " ENTREGA tarde";
                                }
                                
                                this.listaPrestamos.remove(prestamoaux);
                                return devolucionlibro;
                            }
                        }
                    }
                }

            }
        }
        return "error dijite bien el usuario o el nombre del libro";
    }
/**
 * Este método compara las cédulas de los usuarios con la cedula dijitad en la lista de prestamos
 * @param cedula Cédula de un usuario
 * @return si hay un usuario en préstamos con esa cédula lo retorna si no retorna no existe
 */
    public String  buscarPrestamo ( String cedula){
        for (Usuario usuarioaux : listaUsuarios) {
            if(usuarioaux.getCedula().equals(cedula)){
                for (Prestamo preaxu: listaPrestamos) {
                  if (preaxu.getUsuario().equals(usuarioaux)){
                    return " el usuario "+ usuarioaux.getNombre()+ " tiene el libro "+ preaxu.getLibro().getTitulo()+ "  prestado";
                  }  
                }
            }
        }
        return "no exixte ";
    }

    /**
     * Este método me retorna los libros prestados
     *  @return un string de libros
     */
  public  String mostarLibrosPrestados (){
    String librosprestados = "";
    for (Prestamo prestamoaux : listaPrestamos) {
     librosprestados += prestamoaux.toString() ;  
    }
   return librosprestados;
  }
}

