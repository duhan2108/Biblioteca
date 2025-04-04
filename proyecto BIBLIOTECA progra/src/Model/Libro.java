package Model;
/**
 *  Esta clase Libro está creada para representar un libro
 *   @author duhan olarte 
 */
public class Libro{
   /** Título del libro */
   private String titulo;
    
   /** Autor del libro */
   private String autor;
   
   /** Año de publicación del libro */
   private int añoPublicacion;
   
   /** ISBN del libro, identificador único */
   private String isbn;
   
   /** Cantidad de ejemplares disponibles en la biblioteca */
   private int cantidad;

   /**
    * El constructor del libro
    * @param titulo Título del libro
    * @param autor Autor del libro
    * @param añoPublicacion año de publicación
    * @param isbny ISbn viene del libro
    * @param cantidad cantidad de libros
    */
    public Libro(String titulo, String autor, int añoPublicacion, String isbn, int cantidad){
        this.titulo=titulo;
        this.autor=autor;
        this.añoPublicacion=añoPublicacion;
        this.isbn=isbn;
        this.cantidad= cantidad;

   }
  /** @return el  titulo del libro*/
    public String getTitulo() {
        return titulo;
    }

    /**estemetodo cambia el titulo
     *  @param titulo el titulo del libro*/
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    
    /** @return el  autor del libro*/
    public String getAutor() {
        return autor;
    }

    /**estemetodo cambia el autor
     *  @param autor el autor del libro*/
    public void setAutor(String autor) {
        this.autor = autor;
    }


    /** @return el  año de publicacion del libro*/
    public int getAñoDePublicacion() {
        return añoPublicacion;
    }

    /**este metodo cambia el año publicacion
     *  @param agnoDePublicacionel año publicacion  del libro*/
    public void setAgnoDePublicacion(int agnoDePublicacion) {
        this.añoPublicacion = agnoDePublicacion;
    }


    /** @return el  isbn  del libro*/
    public String getIsbn() {
        return isbn;
    }

    /**este metodo cambia el isbn
     *  @param isbn el isbn del libro*/
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    /** @return la cantidad del libro*/
    public int getcantidad() {
        return cantidad;
    }
    /**este metodo cambia la cantidad
     *  @param cantidad la cantidad del libro*/
    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * método muestra toda la información de libro
     */
    @Override
    public String toString() {
        return  "\n" + " titulo:" + titulo + "\n "+ 
                " autor=" + autor +  " Publicacion: " +  añoPublicacion + "\n "+ 
                "isbn=" + isbn + " cantidad:" + cantidad  ;
    }
    
}