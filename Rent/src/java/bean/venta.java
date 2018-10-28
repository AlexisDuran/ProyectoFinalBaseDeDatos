package bean;

public class venta {

    private int id_venta;
    private String date_inicio;
    private String date_fin;
    private int total;

    public int getId_venta() {
        return id_venta;
    }

    public void setId_venta(int id_venta) {
        this.id_venta = id_venta;
    }

    public String getDate_inicio() {
        return date_inicio;
    }

    public void setDate_inicio(String date_inicio) {
        this.date_inicio = date_inicio;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

}
