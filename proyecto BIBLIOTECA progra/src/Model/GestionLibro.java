package Model;

import java.time.LocalDate;
import java.util.ArrayList;
/**
 
 * Esta clase  GestinLibro está creada para manipular todo lo que tiene que ver con libros {@link Libro}.
 * @author duhan olarte
 */
public class GestionLibro {
    /**
     * crea lista de libro 
     */
    private ArrayList <Libro> listaLibros;
  /**
   * metodo constructor 
   */
    public GestionLibro(){
        this.listaLibros=new ArrayList<Libro>();
       
    }

    /**
     * Este método me agrega librosA una lista (listalibros)
     * @param titulo Título del libro
     * @param autorautor del libro
     * @param añoDePublicacion Publicación del libro
     * @param isbn ISBN del libro
     * @param cantidad Cantidad de libros 
     * @return ya existe un libro con el mismo ISBN, devuelve un mensaje de error.
     *         Si el año de publicación es mayor al actual, devuelve un mensaje de error.
     *         Si el registro es exitoso, devuelve un mensaje de confirmación.
     */
    public String agregarLibro(String titulo, String autor, int añoDePublicacion, String isbn, int cantidad){
        LocalDate hoy = LocalDate.now();
        if (hoy.getYear()< añoDePublicacion){
            return "el año es mayor al actual";
        }

        for (Libro libroaux : listaLibros) {
            if (libroaux.getIsbn().equals(isbn) ){
    
       return " no pueden haber 2 libros con el mismo ISBN ";    
    }
    } 
    this.listaLibros.add(new Libro(titulo, autor, añoDePublicacion, isbn, cantidad));
    return "libro agregado a la biblioteca";
    }
/**
 * 
 * @return una lista organizada de libros (litaLibros )
 */
    public String mostrarLibros(){
        String libros=" ";
        for(int i=0; i<listaLibros.size();i++){
            libros+= "\n"+  "Autor: " + listaLibros.get(i).getAutor() + "\n"+ 
            "    Titulo: " + listaLibros.get(i).getTitulo() + 
            "\n"+ "     año: " + listaLibros.get(i).getAñoDePublicacion()+
             "\n"+  "  isbn: " + listaLibros.get(i).getIsbn()+
             "\n"+  " Cantidad: " + listaLibros.get(i).getcantidad();
        
        }
        return libros;
    }
    /**
     * Este método elimina un libro por ISBN
     * @param isbn Es ISBN del libro a borrar
     * @return Sí el ISBN está registrado en la lista retornará mensaje el libro eliminado
     * Si no retornará mensaje de error
     */
    public String eliminarLibro(String isbn){
        for(int i=0; i<listaLibros.size();i++){
            if(isbn.equals(listaLibros.get(i).getIsbn())){
                Libro libroeEliminado=listaLibros.remove(i);
                return "el libro "+ libroeEliminado.getTitulo() + " fue eliminado de la biblioteca";
            }
        }
        return "error ";
    }
     /**
     * Este método busca un usuario con la misma cédula registrada para actualizarlo
     * @param isbn isbn que se actualiza
     * @param titulo nuevo titulo del usuario
     * @param autor nuevo autor del usuario
     * @param agnoDePublicacion  nuevo tipo de usuario (1: estudiante, 2: profesor, 3: ciudadano)
     * @param cantidad cantidad de libros 
     * @return Devuelve un mensaje : actualizado Pero si No encuentra la misma cedula 
       Retorna mensaje  de eror
     */
    public String  actualizarLibro(String isbn, String titulo, String autor, int agnoDePublicacion, int cantidad){
        for(Libro libroaux : listaLibros){
            if(libroaux.getIsbn().equals(isbn)){
                libroaux.setTitulo(titulo);
                libroaux.setAutor(autor);
                libroaux.setAgnoDePublicacion(agnoDePublicacion);
                libroaux.setcantidad(cantidad);
                return "libro "+ titulo + "acualizado ";
            }
        }
        return "eror no encontrado el libro";
    }
/**
 * Este método busca un libro por su autor o su título
 * @param dato Es el dato que tenga el usuario , autor o título
 * @return Si la información de  dato pertenece a algún libro retorna el libro
 * Si no retorna mensaje no coincide
 */


    public String buscarLibro(String dato){
        String resultados="";
        for(Libro libroaux : listaLibros){
            if(libroaux.getAutor().equals(dato) || libroaux.getTitulo().equals(dato)){
                resultados+= "isbn " +  libroaux.getIsbn() +"\n"+
                  " titulo " + libroaux.getTitulo() + " autor " + libroaux.getAutor() + "\n"+
                 " año de publicacion " + libroaux.getAñoDePublicacion() + "\n"+
                  " cantidad de libros disponibles " + libroaux.getcantidad();
            }else{
                resultados="no conincide ningun libro con la busqueda";
            }
        }
        return resultados;
    }
    
   /**
    * Es un método getpara acceder a la lista de libros desde otra clase
    */
    public ArrayList<Libro> getListaLibros() {
        return listaLibros;
    }
   
}

