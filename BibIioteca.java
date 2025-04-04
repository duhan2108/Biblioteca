package Controler;

import Model.GestionLibro;
import Model.GestionUsuario;
import Model.Gestionprestamo;
/**
 * esta clase  Biblioteca está creada Para manipular todo lo que tiene que ver con gestión prestamo {@link Gestionprestamo }
 * gestión libro {@link GestionLibro }
 *  y gestión usuario{@link GestionUsuario }
 *  
 * @author duhan olarte
 * @author Jorge maldonado
 */
public class BibIioteca {
/**
 * objetos de tipo Gestiónpréstamo ,gestiónlibro y gestión usuario
 */
private Gestionprestamo prestamo;
private GestionLibro libro;
private GestionUsuario usuario;

/**
 * Metodo constructor
 */
public  BibIioteca () {
    this.libro = new GestionLibro();
    this.usuario = new GestionUsuario();
    this.prestamo = new Gestionprestamo(libro, usuario);
}
 
/**
 * Este método recibe los parámetros dados por el ejecutante del programa Para agregar un usuario a la biblioteca
 * @param nombre  Nombre usuario
 * @param apellido Apellido usuario
 * @param cedula cédula usuario
 * @param tipoUsuario tipo de usuario
 * @return retorna el mensaje que genara  el método registarUsuario en la clase gestión usuario
 */

  public String registrarUsuario(String nombre, String apellido, String cedula, int tipoUsuario){
     return usuario.registrarUsuario(nombre, apellido, cedula, tipoUsuario);
  }
/**
 * Este método muestra los usuarios
 * @return retorna el mensaje que genera el método mostarUsuarios  en la clase gestión usuario
 */ 

  public String mostrarUsuarios(){
    return usuario.mostrarUsuarios();
  }
/**
 * Este método le envía los parámetros dados por el usuario al método eliminar usuario de la clase gestión usuario
 * @param cedula Cédula del usuario
 * @return retorna el mensaje que genera el método eliminarUsuario en la clase gestión usuario
 */

  public String eliminarUsuario(String cedula){
    return usuario.eliminarUsuario(cedula);
  }

  /**
 * Este método busca un usuario por su cédula
 * @param cedula Cédula del usuario
 * @return retorna el mensaje que genera el método buscarUsuario en la clase gestión usuario
 */
public String buscarUsuario(String cedula) {
  return usuario.buscarUsuario(cedula);
}


  /**
   * Este método le envía los parámetros al método actualizar usuario de la clase gestión usuario
   * @param cedulaCédula del usuario
   * @param nombrenuevo nombre
   * @param apellidonuevo apellido
   * @param tipodeusuario nuevo tipo de usuario
   * @return retorna el mensaje que genera el método atualizarUzuario  en la clase gestión usuario
   */
  public String actualizarUsuario(String cedula, String nombre, String apellido,  int tipodeusuario){
    return  usuario.actualizarUsuario(cedula, nombre , apellido, tipodeusuario);
  }
  /**
   * Este método recibe los parámetros dados por el ejecutante del programa Para agregar un libro a la biblioteca
   * @param titulo Título del libro
   * @param autor autor del libro
   * @param añoDePublicacion año de publicación
   * @param isbn ISBN Del libro
   * @param cantidad cantidad De Ejemplares
   * @return retorna el mensaje que genera el método agregarlibro   en la clase gestiónlibro 
   */

  public String agregarLibro(String titulo, String autor, int añoDePublicacion, String isbn, int cantidad){
    return libro.agregarLibro(titulo, autor, añoDePublicacion, isbn, cantidad);
  }
  /**
   *  este metodod muestra la lista de libros
   * @return la lista que genera el metodo mostarlibros de la clase gestionlibro 
   */
  public String mostrarLibros(){
    return libro.mostrarLibros();
  }
   /**
 * Este método elimina un libro de la biblioteca mediante su ISBN
 * @param isbn Es el ISBN del libro que desea eliminar
 * @return retorna el mensaje generado por el método eliminarLibro de la clase GestionLibro
 */
  public String eliminarlibro  (String isbn){
    return libro.eliminarLibro(isbn);
  }

  /**
 * Este método  envia los parametros para actualizar la información de un libro ya registrado
 * @param isbn ISBN del libro que se desea actualizar
 * @param titulo Nuevo título del libro
 * @param autor Nuevo autor del libro
 * @param agnoDePublicacion Nuevo año de publicación
 * @param cantidad Nueva cantidad de ejemplares disponibles
 * @return retorna el mensaje generado por el método actualizarLibro de la clase GestionLibro
 */
  public String  actualizarLibro(String isbn, String titulo, String autor, int agnoDePublicacion, int cantidad){
    return libro.actualizarLibro(isbn, titulo, autor, agnoDePublicacion, cantidad);
  }

  /**
 * Este método busca un libro por su título o por su autor
 * @param dato Dato proporcionado por el usuario (puede ser título o autor)
 * @return retorna el resultado generado por el método buscarLibro de la clase GestionLibro
 */
public String buscarLibro(String dato){
    return libro.buscarLibro(dato);
}

/**
 * Este método envia los parametros para un préstamo de un libro a un usuario
 * @param cedula Cédula del usuario que solicita el préstamo
 * @param isbn ISBN del libro solicitado
 * @return Retorna el mensaje generado por el método realizarPrestamo de la clase GestionPrestamo
 */

public String realizarPrestamo(String cedula, String isbn){
        return prestamo.realizarPrestamo(cedula, isbn );
}
/**
 * Este método envia los parametros para  la devolución de un libro prestado
 * @param cedula Cédula del usuario que devuelve el libro
 * @param isbn ISBN del libro a devolver
 * @return Retorna el mensaje generado por el método realizarDevolucion de la clase GestionPrestamo
 */
public String devolver (String cedula, String isbn){
return prestamo.realizarDevolucion(cedula, isbn);
}
 /**
   *  este metodod muestra la lista de libros prestados 
   * @return la lista que genera el metodo mostarlibros de la clase gestionlibro 
   */

public String mostarlibrosprestados(){
    return prestamo.mostarLibrosPrestados();
}
/**
 * Este método busca préstamos de libros asociados a una cédula
 * @param cedula Cédula del usuario a consultar
 * @return Retorna el resultado generado por el método buscarPrestamo de la clase GestionPrestamo
 */
public String bucarPrestamoPorcedula (String cedula ){
  return prestamo.buscarPrestamo(cedula);
}

}
