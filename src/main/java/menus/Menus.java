package menus;

import acciones.Salon;
import java.sql.Connection;

    public class Menus {

        //Atributos de la instancia
        /*Connection connection;*/
        protected int id;
        protected String nombre_tbl;
        protected String plato;
        protected Double precio;
        protected Salon salon;

        //método constructor que requiere de datos al momento de la instanciacion

    /*MySQLConnection conexion = new MySQLConnection();
    MenuPersistenceUseMSQL menuPers = new MenuPersistenceUseMSQL();
    this.menuPers = new MenuPersistenceUseMSQL();*/


        public Menus(int id, String nombre_tbl) {

            setId(id);
            setNombre(nombre_tbl);
            setPlato(plato);
            setPrecio(precio);

            this.salon = new Salon();
        }

        //métodos de la instancia

        public void alquiler(int countcomen) {
            salon.alquilar(countcomen);
        }

        //métodos de la clase

        public int getId(){
            return id;
        }
        public String getNombre(){
            return nombre_tbl;
        }
        public String getPlato() {
            return plato;
        }
        public Double getPrecio() {
            return precio;
        }
        public String getPlato(int id, String nombre_tbl) {
            return plato;
        }

        public Salon getSalon() {
            return salon;
        }

        public void setId(int id) {
            this.id = id;
        }
        public void setNombre(String nombre_tbl) {
            this.nombre_tbl = nombre_tbl;
        }
        public void setPlato(String plato) {
            this.plato = plato;
        }

        public void setPrecio(Double precio) {
            this.precio = precio;
        }



    }



