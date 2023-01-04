import java.sql.Connection;
import java.util.Scanner;
import acciones.Salon;
import menus.Menus;
import persistencia.msql.MenuPersistenceUseMySQL;
import persistencia.msql.MySQLConnection;


public class Main {

    static Menus menu;
    static Salon salon;
    static Scanner teclado = new Scanner(System.in);
    static Connection connection;
    static MySQLConnection conexion = new MySQLConnection();
    static MenuPersistenceUseMySQL menuPersistence = new MenuPersistenceUseMySQL();
    static String nombre_tbl;
    static int id;
    static String plato;
    static Double precio;
    public static void main (String [] args) {

        Double alq;
        salon = new Salon();
        menu = new Menus(id, nombre_tbl);
        /*int id1;
        String plato1;
        Double precio1;*/

        connection = null;

        System.out.println("Ingrese la cantidad de egresados e invitados total: ");
        int countcomen = teclado.nextInt();
        salon.alquilar(countcomen);
        alq = salon.getCostsalon();


        connection = conexion.establecerConexion();
        nombre_tbl = "plato_entrada";
        System.out.println("Ingrese el plato de entrada elegido[1-2-3]: ");
        int id_plato_entrada = teclado.nextInt();

        menu = menuPersistence.ElecMenus(connection, id_plato_entrada,"plato_entrada");
        int id1 = menu.getId();
        String plato1 = menu.getPlato();
        Double precio1 = menu.getPrecio();
        System.out.println(menu.getId());
        System.out.println(menu.getPlato());
        System.out.println(menu.getPrecio());
        conexion.cerrarConexion(connection);

        System.out.println("Ingrese el plato principal elegido[1-2-3]: ");
        int id_plato_principal = teclado.nextInt();
        nombre_tbl = "plato_principal";

        menu = menuPersistence.ElecMenus(connection, id_plato_principal,"plato_principal");
        int id2 = menu.getId();
        String plato2 = menu.getPlato();
        Double precio2 = menu.getPrecio();
        System.out.println(menu.getPlato());
        System.out.println(menu.getPrecio());
        conexion.cerrarConexion(connection);

        System.out.print("Ingrese el plato postre elegido[1-2-3]: ");
        int id_plato_postre = teclado.nextInt();
        nombre_tbl = "plato_postre";

        menu = menuPersistence.ElecMenus(connection, id_plato_postre,"plato_postre");
        int id3 = menu.getId();
        String plato3 = menu.getPlato();
        Double precio3 = menu.getPrecio();
        System.out.println(menu.getPlato());
        System.out.println(menu.getPrecio());
        conexion.cerrarConexion(connection);

        for(Menus menu : menuPersistence.getAllMenus()){
            System.out.println((menu));
        }
        System.out.print( "De acuerdo a las elecciones realizadas de los platos a servirse en Cena de Egresados\n" );
        System.out.print( "El PRESUPUESTO TOTAL sin descuento ES: " );
        System.out.println(precio1 + precio2 + precio3 + alq);

    }
}