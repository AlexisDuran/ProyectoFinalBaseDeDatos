package dao;

import bean.cliente;
import conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private String sql = "insert into Cliente(nombre,rfc,direccion,telefono,correo)values(?,?,?,?,?);";
    private String sql2 = "select * from Cliente";

    //METODO DE INSERT CLIENTE
    public boolean insertCliente(cliente cl) throws SQLException {
        boolean resultado = false;

        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql);

        pstInsert.setString(1, cl.getNombre());
        pstInsert.setString(2, cl.getRfc());
        pstInsert.setString(3, cl.getDireccion());
        pstInsert.setString(4, cl.getTelefono());
        pstInsert.setString(5, cl.getCorreo());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE CONSULTAS
    public List<cliente> consulta() throws SQLException {

        List<cliente> listaClientes = new ArrayList<cliente>();   //<cliente>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql2);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            cliente cl = new cliente();

            cl.setId_cliente(rs.getInt(1));
            cl.setNombre(rs.getString(2));
            cl.setRfc(rs.getString(3));
            cl.setDireccion(rs.getString(4));
            cl.setTelefono(rs.getString(5));
            cl.setCorreo(rs.getString(6));

            listaClientes.add(cl);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaClientes;
    }

    //METODO DE BUSCAR CLIENTES
    public List<cliente> buscarCliente(cliente client) throws SQLException {

        String sql3 = "SELECT * FROM cliente WHERE id_cliente =" + client.getId_cliente();
        List<cliente> listaClientes = new ArrayList<cliente>();   //<cliente>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql3);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            cliente cl = new cliente();

            cl.setId_cliente(rs.getInt(1));
            cl.setNombre(rs.getString(2));
            cl.setRfc(rs.getString(3));
            cl.setDireccion(rs.getString(4));
            cl.setTelefono(rs.getString(5));
            cl.setCorreo(rs.getString(6));

            listaClientes.add(cl);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaClientes;
    }

    //METODO DE ACTUALIZAR CLIENTES
    public boolean actualizarCliente(cliente cl) throws SQLException {
        boolean resultado = false;
        String sql4 = "UPDATE cliente SET nombre=?,rfc=?,direccion=?,telefono=?,correo=? WHERE id_cliente = " + cl.getId_cliente();
        /*
            UPDATE STRUTS2CRUD SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE UEMAIL=?";

         */
        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql4);

        pstInsert.setString(1, cl.getNombre());
        pstInsert.setString(2, cl.getRfc());
        pstInsert.setString(3, cl.getDireccion());
        pstInsert.setString(4, cl.getTelefono());
        pstInsert.setString(5, cl.getCorreo());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE ELIMINAR CLIENTES
    public boolean eliminarCliente(cliente client) throws SQLException {
        String sql5 = "DELETE FROM cliente WHERE id_cliente =" + client.getId_cliente();
        //<cliente>
        boolean resultado = false;
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql5);
        //pst.executeQuery();

        if (pst.executeUpdate() == 1) {
            resultado = true;

            pst.close();
            conn.close();
        }
        return false;
    }

}
