package Model;

/**
* Representa un usuario en el sistema de biblioteca.
* Puede ser un estudiante, profesor u otro tipo de usuario permitido en la biblioteca.
* 
* @author jorge maldonado 
*/

public class Usuario {
/**
   * Nombre del usuario.
   */
  private String nombre;

  /**
   * Apellido del usuario.
   */
  private String apellido;

  /**
   * Cédula del usuario (identificación única).
   */
  private String cedula;

  /**
   * Tipo de usuario (ejemplo: estudiante, profesor, ciudadano, etc.).
   */
  private String tipoUsuario;

  /**
   * Constructor de la clase Usuario.
   * 
   * @param nombre Nombre del usuario.
   * @param apellido Apellido del usuario.
   * @param cedula Cédula del usuario.
   * @param tipoUsuario Tipo de usuario en la biblioteca.
   */
  public Usuario(String nombre, String apellido, String cedula, String tipoUsuario) {
      this.nombre = nombre;
      this.apellido = apellido;
      this.cedula = cedula;
      this.tipoUsuario = tipoUsuario;
  }

  /**
   * Obtiene el nombre del usuario.
   * 
   * @return Nombre del usuario.
   */
  public String getNombre() {
      return nombre;
  }

  /**
   * Asigna un nuevo nombre al usuario.
   * 
   * @param nombre Nuevo nombre del usuario.
   */
  public void setNombre(String nombre) {
      this.nombre = nombre;
  }

  /**
   * Obtiene el apellido del usuario.
   * 
   * @return Apellido del usuario.
   */
  public String getApellido() {
      return apellido;
  }

  /**
   * Asigna un nuevo apellido al usuario.
   * 
   * @param apellido Nuevo apellido del usuario.
   */
  public void setApellido(String apellido) {
      this.apellido = apellido;
  }

  /**
   * Obtiene la cédula del usuario.
   * 
   * @return Cédula del usuario.
   */
  public String getCedula() {
      return cedula;
  }

  /**
   * Asigna una nueva cédula al usuario.
   * 
   * @param cedula Nueva cédula del usuario.
   */
  public void setCedula(String cedula) {
      this.cedula = cedula;
  }

  /**
   * Obtiene el tipo de usuario.
   * 
   * @return Tipo de usuario (Ej: estudiante, profesor, etc.).
   */
  public String getTipoUsuario() {
      return tipoUsuario;
  }

  /**
   * Asigna un nuevo tipo de usuario.
   * 
   * @param tipoUsuario Nuevo tipo de usuario.
   */
  public void setTipoUsuario(String tipoUsuario) {
      this.tipoUsuario = tipoUsuario;
  }

  /**
   * Representa la información del usuario en formato de cadena de texto.
   * 
   * @return Información del usuario .
   */
  @Override
  public String toString() {
      return "\nUsuario nombre=" + nombre + " apellido=" + apellido + "\n" + 
             "Cédula=" + cedula + " TipoUsuario=" + tipoUsuario;
  }
}
