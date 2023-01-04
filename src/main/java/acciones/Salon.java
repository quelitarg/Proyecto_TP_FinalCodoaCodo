package acciones;

public class Salon {

    protected int countcomen;
    protected Double costsalon;
    protected Double usesxpers = 1700.0;

    public void Salon() {
        this.countcomen = countcomen;
        this.costsalon = costsalon;
    }

    public void alquilar(int countcomen) {

            costsalon = countcomen * usesxpers;
            System.out.println("El costo del salón es: $ " + costsalon);
        }

    public Double getCostsalon() {
        return costsalon;
    }

    public void setCostsalon(Double costsalon) {
        this.costsalon = costsalon;
    }

    public void setCountcomen(int countcomen) {
        this.countcomen = countcomen;
    }
}


