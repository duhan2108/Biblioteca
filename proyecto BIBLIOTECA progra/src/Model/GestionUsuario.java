package Model;

import java.util.ArrayList;
/**
 * La clase gestiónusuario está creada para manipular
 *  todo lo que tiene que ver con usuarios {@link Usuario}
 *  
 *  @author Duhan olarte 
 * @author Jorge maldonado
 */
public class GestionUsuario {
   /**
    * Crea la lista de usuario
    */
    private ArrayList <Usuario> listaUsuarios;

    /**
     * metodo constructor 
     */
    public GestionUsuario(){
         this.listaUsuarios=new ArrayList<Usuario>();
       
    }
   /**
    * este método registra usuarios o guarda usuarios en la lista de usuarios
    * @param nombre nombre del usario.
    * @param apellido apellido del usuario
    * @param cedula cedula  del usuario
    * @param tipoUsuario  tipo de usuario (1 , 2 0 3)
    * @return  Devuelve un mensaje : registro con exito Pero si hay Otro usuario inscrito con el mismo id
       Retorna mensaje  de eror 
    */
   
    public String registrarUsuario(String nombre, String apellido, String cedula, int tipoUsuario){
        for (Usuario usuarioaux : listaUsuarios) {
        if (usuarioaux.getCedula().equals(cedula)) {
        return "ERROR  ya hay un usario con esa cedula " ;
        }}
        if(tipoUsuario==1){
            this.listaUsuarios.add(new Usuario(nombre, apellido, cedula, "estudiante"));
        }else if(tipoUsuario==2){
            this.listaUsuarios.add(new Usuario(nombre, apellido, cedula, "profesor"));
        }else if(tipoUsuario==3){
            this.listaUsuarios.add(new Usuario(nombre, apellido, cedula, "ciudadano"));
        }
        return "usuario registrado con exito";
    }
    /**
     * 
     * @return una lista de usuarios
     */
    public String mostrarUsuarios(){
        String usuarios=" ";
        for(int i=0; i<listaUsuarios.size();i++){
            usuarios+=  "nombre: " + listaUsuarios.get(i).getNombre() + "\n"+ 
            "    apellido: " + listaUsuarios.get(i).getApellido() + 
            "\n"+ "     cedula: " + listaUsuarios.get(i).getCedula() +
             "\n"+  "     tipo de usuario: " + listaUsuarios.get(i).getTipoUsuario();
        }
        return usuarios;
    }
    /**
     * 
     * @param cedula la cédula del usuario que se va a eliminar
     * @return un mensaje de confirmacion eliminado
     *  Si la célula   del usuario no esta registardo retorna  mensaje no existe
     */
    public String eliminarUsuario(String cedula){
      for (Usuario usuarioaux : listaUsuarios) {
        if(usuarioaux.getCedula().equals(cedula)){
           this.listaUsuarios.remove(usuarioaux); 
           return " eliminado";
        }
    }
    return " no existe ";
    }
    /**
     * Este método busca un usuario con la misma cédula registrada para actualizarlo
     * @param cedula la cedula de usuario que se actualiza
     * @param nombre nuevo nombre del usuario
     * @param apellido nuevo apellido del usuario
     * @param tipodeusuario nuevo tipo de usuario (1: estudiante, 2: profesor, 3: ciudadano)
     * @return Devuelve un mensaje : actualizado Pero  si No encuentra la misma cedula 
       Retorna mensaje  de eror
     */
    public String actualizarUsuario(String cedula, String nombre, String apellido ,int tipodeusuario){
       
        for (Usuario usuarioAux : listaUsuarios ){
            if(usuarioAux.getCedula().equals(cedula)){
                if(tipodeusuario==1){
                    usuarioAux.setTipoUsuario("estudiante");
                }else if(tipodeusuario==2){
                    usuarioAux.setTipoUsuario("profesor");
                }else if(tipodeusuario==3){
                    usuarioAux.setTipoUsuario("ciudadano");
                }
              usuarioAux.setNombre(nombre);
              usuarioAux.setApellido(apellido);

               return" actualizado" ;
            }
        }
        return "error";
    }
  /**
   * Este método compara las cédulas de los usuarios con cedula y la que sea igual, muestra los datos de usuario
   * @param cedula cedual buscada
   * @return un usuario  si la cedula es igual sino muestra no exixte 
   */
    public String buscarUsuario ( String cedula){
        for (Usuario usuarioaux : listaUsuarios) {
            if(usuarioaux.getCedula().equals(cedula)){
                return usuarioaux.toString();
            }
        }
        return " no exixte ";
    }

   /**
    * 
    * Es un método getter para acceder a la lista de usuarios  desde otra clase 
    */
    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
}

