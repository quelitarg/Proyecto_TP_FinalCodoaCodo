package persistencia;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import menus.Menus;


public interface IMenuPersistence {

    List<Menus> bdMenus = new ArrayList<>();


    Menus ElecMenus(Connection connection, int id, String nombre_tbl);
    void guardar(Menus menu);
    Menus getMenus(int id, String nombre_tbl);
    List<Menus> getAllMenus();
    void updateMenus(Menus menu);
    void deleteMenus(int id, String nombre_tbl);

}
