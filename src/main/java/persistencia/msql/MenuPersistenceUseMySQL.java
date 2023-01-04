package persistencia.msql;

import menus.Menus;
import persistencia.IMenuPersistence;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MenuPersistenceUseMySQL implements IMenuPersistence {

        MySQLConnection mySQLConnection;
        Connection connection;
        Menus menus;

        public MenuPersistenceUseMySQL() {
            this.mySQLConnection = new MySQLConnection();
            this.connection = mySQLConnection.establecerConexion();

        }


    public Menus ElecMenus(Connection connection, int id, String nombre_tbl) {

            try {
                // Crear una instrucción SQL SELECT
                String sql = "SELECT 1, 2, 3 FROM " + nombre_tbl + " WHERE id = ?";
                // Crear un objeto PreparedStatement
                PreparedStatement stmt = connection.prepareStatement(sql);
                // Establecer el valor del parámetro
                stmt.setInt(1, id);
                // Ejecutar la instrucción SQL y obtener el resultado
                ResultSet rs = stmt.executeQuery(sql);

                // Verificar si se obtuvo un registro
                if (rs.next()) {
                    // Crear un objeto Menu y establecer sus valores
                    Menus menu = new Menus(id, nombre_tbl);
                    menu.setId(rs.getInt("1"));
                    menu.setPlato(rs.getString("2"));
                    menu.setPrecio(rs.getDouble("3"));
                    // Devolver el objeto menu
                    return menu;
                }

            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            // Si no se obtuvo ningún registro, devolver null
            return null;
        }

    @Override
    public void guardar(Menus menu) {
        bdMenus.add(menu);
    }

    @Override
    public Menus getMenus(int id, String nombre_tbl) {
            return null;
    }

    /*@Override
    public Menus getMenus(int id) {
        return bdMenus.get(id);
    }*/

    /*@Override
    public Menus getMenus(int id, String nombre_tbl) {
        return bdMenus.get(id, nombre_tbl);
    }*/

    @Override
    public List<Menus> getAllMenus() {
        return bdMenus;
    }

    @Override
    public void updateMenus(Menus menu) {

    }

    @Override
    public void deleteMenus(int id, String nombre_tbl) {

    }

    /*@Override
    public void deleteMenus(int id, String nombre_tbl) {
            bdMenus.remove(getMenus(id, nombre_tbl));
    }*/

}
