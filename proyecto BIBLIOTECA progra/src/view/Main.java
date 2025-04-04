package view;

import Controler.BibIioteca;

import java.util.Scanner;

import javax.swing.JOptionPane;

/**
 * Clase principal que ejecuta el sistema de gestión de biblioteca.
 * Permite registrar usuarios, agregar libros y realizar préstamos.
 * 
 *  @author Jorge villamil
 * @author duhan olarte 
 * 
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BibIioteca biblioteca = new BibIioteca();
        boolean procesando = true;
        /**
         * bucle que se termina cuando precesando sea false en en caso 
         */
        while (procesando) {
            String menu = """
                    Seleccione una opción:
                    1: Agregar un nuevo libro.
                    2: Ver lista de libros.
                    3: Eliminar libro de la lista.
                    4: Actualizar información de libro.
                    5: Buscar libro por título o autor.
                    6: Registrar usuario.
                    7: Ver lista de usuarios registrados.
                    8: Eliminar usuario .
                    9: Actualizar información de usuario.
                    10: Gestionar préstamo de libro.
                    11: devolución de libro.
                    12: Mostar libros prestados
                    13: buscar prestamos por cedula del usuario
                    14: buscar usuarios
                     15 o cualquier numero. SALIR.
                    """;

            String opcionStr = JOptionPane.showInputDialog(menu);

            if (opcionStr == null) {
                JOptionPane.showMessageDialog(null, "ERROR");
                break;
            }
            int opcion = Integer.parseInt(opcionStr);
            switch (opcion) {
                case 1:
                    String nombre = JOptionPane.showInputDialog("Ingrese nombre del libro :");
                    String autor = JOptionPane.showInputDialog("Ingrese el autor");
                    String isbn = JOptionPane.showInputDialog("Ingrese su ISNB:");
                    int publicacion = Integer.parseInt(JOptionPane.showInputDialog("año de pulicacion:"));
                    int numeroEjemplaresDisponibles = Integer.parseInt(JOptionPane.showInputDialog("ejemplares:"));
                    String agendao = biblioteca.agregarLibro(nombre, autor, publicacion, isbn,
                            numeroEjemplaresDisponibles);
                    JOptionPane.showMessageDialog(null, agendao);
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null, biblioteca.mostrarLibros());
                    break;
                case 3:
                    String eliminar = JOptionPane.showInputDialog("Ingrese ISBN del libro :");
                    String eliminado = biblioteca.eliminarlibro(eliminar);
                    JOptionPane.showMessageDialog(null, eliminado);
                    break;
                case 4:
                    String aisbn = JOptionPane.showInputDialog("Ingrese  ISBN del libro a actualizar :");
                    String anombre = JOptionPane.showInputDialog("Ingrese nombre del nuevo libro  :");
                    String aautor = JOptionPane.showInputDialog("Ingrese el autor");
                    int apublicacion = Integer.parseInt(JOptionPane.showInputDialog("año de pulicacion:"));
                    int anumeroEjemplaresDisponibles = Integer
                            .parseInt(JOptionPane.showInputDialog("numero de ejemplares "));
                    String actualizar = biblioteca.actualizarLibro(aisbn, anombre, aautor, apublicacion,
                            anumeroEjemplaresDisponibles);
                    JOptionPane.showMessageDialog(null, actualizar);
                    break;
                case 5:
                    String busqueda = JOptionPane
                            .showInputDialog("digite El título o el autor del libro que desea buscar  ");
                    String resultado = biblioteca.buscarLibro(busqueda);
                    JOptionPane.showMessageDialog(null, resultado);
                    break;
                case 6:
                    String user = "eror";
                    String nombreUsuario = JOptionPane.showInputDialog("Ingrese  el  nombre  :");
                    String apellido = JOptionPane.showInputDialog("Ingrese el apellido");
                    String cedula = JOptionPane.showInputDialog("Ingrese la cedula :");
                    int tipoUsuario = 0;
                    String[] opc = {
                            "1:estudiante.",
                            "2:profesor.",
                            "3:ciudadano." };

                    int elecion = JOptionPane.showOptionDialog(null, "Seleccione una opción: Tipo de usario", "Menú",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opc, opc[0]);
                    if (elecion == 0) {
                        tipoUsuario = 1;
                        user = biblioteca.registrarUsuario(nombreUsuario, apellido, cedula, tipoUsuario);
                    }
                    if (elecion == 1) {
                        tipoUsuario = 2;
                        user = biblioteca.registrarUsuario(nombreUsuario, apellido, cedula, tipoUsuario);
                    }
                    if (elecion == 2) {
                        tipoUsuario = 3;
                        user = biblioteca.registrarUsuario(nombreUsuario, apellido, cedula, tipoUsuario);
                    }

                    JOptionPane.showMessageDialog(null, user);

                    break;
                case 7:
                    String usarios = biblioteca.mostrarUsuarios();
                    JOptionPane.showMessageDialog(null, usarios);

                    break;
                case 8:
                    String cedulaEliminado = JOptionPane
                            .showInputDialog("digite la cedula del usuario que desea eliminar  ");
                    String usuarioBorrado = biblioteca.eliminarUsuario(cedulaEliminado);
                    JOptionPane.showMessageDialog(null, usuarioBorrado);

                    break;
                case 9:
                    String actualizarUsuario = " ERROR";
                    String cedulaUsuario = JOptionPane.showInputDialog("digite la cedula del usuario a actualizar ");
                    String aapellido = JOptionPane.showInputDialog("Ingrese el nuevo  apellido");
                    String nombres= JOptionPane.showInputDialog("Ingrese el nombre :");
                    int usuarioTipo = 0;
                    String[] opci = {
                            "1:estudiante.",
                            "2:profesor.",
                            "3:ciudadano." };

                    int elec = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Menú",
                            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opci, opci[0]);
                    if (elec == 0) {
                        tipoUsuario = 1;
                        actualizarUsuario = biblioteca.actualizarUsuario(cedulaUsuario,nombres, aapellido, usuarioTipo);
                    }
                    if (elec == 1) {
                        tipoUsuario = 2;
                        actualizarUsuario = biblioteca.actualizarUsuario(cedulaUsuario,nombres, aapellido, usuarioTipo);
                    }
                    if (elec == 2) {
                        tipoUsuario = 3;
                        actualizarUsuario = biblioteca.actualizarUsuario(cedulaUsuario,nombres, aapellido, usuarioTipo);
                    }

                    JOptionPane.showMessageDialog(null, actualizarUsuario);
                    break;

                case 10:
                    String cedulaUsuarioSolicitante = JOptionPane
                            .showInputDialog("digite la cedula del usuario que pide el libro ");

                    String isbnDelLibroSolicitado = JOptionPane.showInputDialog("digite el isbn del pedido");

                    String solicitud = biblioteca.realizarPrestamo(cedulaUsuarioSolicitante, isbnDelLibroSolicitado);
                    JOptionPane.showMessageDialog(null, solicitud);
                    break;
                case 11:

                    String cedulaUsuarioDevolucion = JOptionPane.showInputDialog("digite la cedula del usuario que devuelve el libro");

                    String isbnDelLibroDevuelto = JOptionPane.showInputDialog("digite el isbn del libro a devolver");

                    String devolucion = biblioteca.devolver(cedulaUsuarioDevolucion, isbnDelLibroDevuelto);
                
                    JOptionPane.showMessageDialog(null, devolucion);

                    break;
                case 12:
                    JOptionPane.showMessageDialog(null, biblioteca.mostarlibrosprestados());

                    break;
                case 13:
                String cedulabuscado= JOptionPane.showInputDialog("digite la cedula del  usuario con prestamo que desa buscar  ");
                String usuarioBuscado = biblioteca.bucarPrestamoPorcedula(cedulabuscado);
                JOptionPane.showMessageDialog(null, usuarioBuscado);
                break;

                case 14:
                String cedulabusca= JOptionPane.showInputDialog("digite la cedula del usuario que desea buscar  ");
                String usuarioBusca = biblioteca.buscarUsuario(cedulabusca);
                JOptionPane.showMessageDialog(null, usuarioBusca);
                break;
                default:
                    procesando = false;
                    break;
            }
        }
        sc.close();
    }
}

