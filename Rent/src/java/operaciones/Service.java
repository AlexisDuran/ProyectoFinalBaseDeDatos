package operaciones;

import com.opensymphony.xwork2.ActionSupport;
import bean.cliente;
import bean.venta;
import bean.caracteristicas;
import bean.renter;
import dao.CaractDAO;
import dao.ClienteDAO;
import dao.VentaDAO;
import dao.renterDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Service extends ActionSupport {
    //Variables de Listas para Consultas

    private List<cliente> lista = new ArrayList<cliente>();
    private List<caracteristicas> listaCaract = new ArrayList<caracteristicas>();
    private List<venta> listaVenta = new ArrayList<venta>();
    private List<renter> listaRenter = new ArrayList<renter>();
    private List<cliente> listaBuscarCliente = new ArrayList<cliente>();
    private List<caracteristicas> listaBuscarCaracteristica = new ArrayList<caracteristicas>();
    private List<venta> listaBuscarVenta = new ArrayList<venta>();
    private List<renter> listaBuscarRenter = new ArrayList<renter>();
    private int id;

    //instancias de clases
    private cliente client = new cliente();     //
    private caracteristicas cara = new caracteristicas();
    private venta venta = new venta();
    private renter rent = new renter();

    //
    @Override
    //METODOS DE INSERTAR
    public String execute() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();   //creacion del cliente DAO
        clienteDao.insertCliente(client);   //llamar metodo insertCliente  de @ClienteDAO
        return SUCCESS;
    }

    public String executeLap() throws SQLException {
        CaractDAO carDao = new CaractDAO();   //creacion de la Carac...
        carDao.insertCaract(cara);   //llamar metodo insertar Caract...
        return SUCCESS;
    }       //listo :D

    public String executeVenta() throws SQLException {
        VentaDAO ventaDao = new VentaDAO();   //creacion del venta DAO
        ventaDao.insertVenta(venta);   //llamar metodo insertVenta
        return SUCCESS;
    }

    public String executeRenter() throws SQLException {
        renterDAO rentDao = new renterDAO();   //creacion de renter
        rentDao.insertRenter(getRent());   //llamar metodo insertar
        return SUCCESS;
    }

    //METODOS DE CONSULTA
    public String consulta() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();   //creacion de cliente DAO
        setLista(clienteDao.consulta());  //llamar metodo consulta  de @ClienteDAO
        return SUCCESS; //SUCCESS
    }

    public String consultaLap() throws SQLException {
        CaractDAO carDao = new CaractDAO();   //creacion de la Carac...
        setListaCaract(carDao.consulta());  //llamar metodo consulta  de carDao
        return SUCCESS; //SUCCESS
    }

    public String consultaVenta() throws SQLException {
        VentaDAO ventaDao = new VentaDAO();   //creacion venta
        setListaVenta(ventaDao.consulta());  //llamar metodo consulta
        return SUCCESS; //SUCCESS
    }

    public String consultaRenter() throws SQLException {
        renterDAO rentDao = new renterDAO();   //creacion de renter
        setListaRenter(rentDao.consulta());  //llamar metodo consulta
        return SUCCESS; //SUCCESS
    }

    //METODOS BUSCAR
    public String buscarCliente() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();
        setListaBuscarCliente(clienteDao.buscarCliente(client));
        return SUCCESS; //
    }

    public String buscarCaracteristica() throws SQLException {
        CaractDAO caraDAO = new CaractDAO();   //
        setListaBuscarCaracteristica(caraDAO.buscarCaracteristica(cara));  //
        return SUCCESS; //
    }

    public String buscarVenta() throws SQLException {
        VentaDAO ventaDAO = new VentaDAO();   //
        setListaBuscarVenta(ventaDAO.buscarVenta(venta));  //
        return SUCCESS; //
    }

    public String buscarRenter() throws SQLException {
        renterDAO renterDao = new renterDAO();   //
        setListaBuscarRenter(renterDao.buscarRenter(rent));  //
        return SUCCESS; //
    }

    //METODOS DE ACTUALIZAR
    public String actualizarCliente() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();
        clienteDao.actualizarCliente(client);
        return SUCCESS;
    }

    public String actualizarCaracteristica() throws SQLException {
        CaractDAO caraDAO = new CaractDAO();
        caraDAO.actualizarCaracteristica(cara);
        return SUCCESS;
    }

    public String actualizarVenta() throws SQLException {
        VentaDAO ventaDao = new VentaDAO();
        ventaDao.actualizarVenta(venta);
        return SUCCESS;
    }

    public String actualizarRenter() throws SQLException {
        renterDAO renterDao = new renterDAO();
        renterDao.actualizarRenter(rent);
        return SUCCESS;
    }

    //METODOS ELIMINAR
    public String eliminarCliente() throws SQLException {
        ClienteDAO clienteDao = new ClienteDAO();   //
        clienteDao.eliminarCliente(client);  //
        return SUCCESS; //
    }

    public String eliminarCaracteristica() throws SQLException {
        CaractDAO caraDAO = new CaractDAO();   //
        caraDAO.eliminarCaracteristica(cara);  //
        return SUCCESS; //
    }

    public String eliminarVenta() throws SQLException {
        VentaDAO ventaDao = new VentaDAO();   //
        ventaDao.eliminarVenta(venta);  //
        return SUCCESS; //
    }

    public String eliminarRenter() throws SQLException {
        renterDAO renterDao = new renterDAO();   //
        renterDao.eliminarRenter(rent);  //
        return SUCCESS; //
    }

    //
    //GETS & SETS
    public cliente getClient() {
        return client;
    }

    public void setClient(cliente cl) {
        this.client = cl;
    }

    public List<cliente> getLista() {
        return lista;
    }

    public void setLista(List<cliente> lista) {
        this.lista = lista;
    }

    public caracteristicas getCara() {
        return cara;
    }

    public void setCara(caracteristicas cara) {
        this.cara = cara;
    }

    public List<caracteristicas> getListaCaract() {
        return listaCaract;
    }

    public void setListaCaract(List<caracteristicas> listaCaract) {
        this.listaCaract = listaCaract;
    }

    public List<venta> getListaVenta() {
        return listaVenta;
    }

    public void setListaVenta(List<venta> listaVenta) {
        this.listaVenta = listaVenta;
    }

    public venta getVenta() {
        return venta;
    }

    public void setVenta(venta venta) {
        this.venta = venta;
    }

    /**
     * @return the listaRenter
     */
    public List<renter> getListaRenter() {
        return listaRenter;
    }

    /**
     * @param listaRenter the listaRenter to set
     */
    public void setListaRenter(List<renter> listaRenter) {
        this.listaRenter = listaRenter;
    }

    /**
     * @return the rent
     */
    public renter getRent() {
        return rent;
    }

    /**
     * @param rent the rent to set
     */
    public void setRent(renter rent) {
        this.rent = rent;
    }

    /**
     * @return the listaBuscarCliente
     */
    public List<cliente> getListaBuscarCliente() {
        return listaBuscarCliente;
    }

    /**
     * @param listaBuscarCliente the listaBuscarCliente to set
     */
    public void setListaBuscarCliente(List<cliente> listaBuscarCliente) {
        this.listaBuscarCliente = listaBuscarCliente;
    }

    /**
     * @return the listaBuscarCaracteristica
     */
    public List<caracteristicas> getListaBuscarCaracteristica() {
        return listaBuscarCaracteristica;
    }

    /**
     * @param listaBuscarCaracteristica the listaBuscarCaracteristica to set
     */
    public void setListaBuscarCaracteristica(List<caracteristicas> listaBuscarCaracteristica) {
        this.listaBuscarCaracteristica = listaBuscarCaracteristica;
    }

    /**
     * @return the listaBuscarVenta
     */
    public List<venta> getListaBuscarVenta() {
        return listaBuscarVenta;
    }

    /**
     * @param listaBuscarVenta the listaBuscarVenta to set
     */
    public void setListaBuscarVenta(List<venta> listaBuscarVenta) {
        this.listaBuscarVenta = listaBuscarVenta;
    }

    /**
     * @return the listaBuscarRenter
     */
    public List<renter> getListaBuscarRenter() {
        return listaBuscarRenter;
    }

    /**
     * @param listaBuscarRenter the listaBuscarRenter to set
     */
    public void setListaBuscarRenter(List<renter> listaBuscarRenter) {
        this.listaBuscarRenter = listaBuscarRenter;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
}
