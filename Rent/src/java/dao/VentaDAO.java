package dao;

import bean.venta;
import conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VentaDAO {

    private String sql = "insert into Venta(date_inicio,date_fin,total)values(convert(date,?),convert(date,?),?);";//convert(date,?) jalo!
    private String sql2 = "select * from Venta";

    //METODO DE INSERT
    public boolean insertVenta(venta venta) throws SQLException {
        boolean resultado = false;

        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql);

        pstInsert.setString(1, venta.getDate_inicio());     //
        pstInsert.setString(2, venta.getDate_fin());        //
        pstInsert.setInt(3, venta.getTotal());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE CONSULTAS
    public List<venta> consulta() throws SQLException {

        List<venta> listaVenta = new ArrayList<venta>();   //<venta>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql2);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            venta venta = new venta();

            venta.setId_venta(rs.getInt(1));
            venta.setDate_inicio(rs.getString(2));
            venta.setDate_fin(rs.getString(3));
            venta.setTotal(rs.getInt(4));

            listaVenta.add(venta);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaVenta;
    }

    //METODO DE BUSCAR CLIENTES
    public List<venta> buscarVenta(venta vent) throws SQLException {

        String sql3 = "SELECT * FROM venta WHERE id_venta =" + vent.getId_venta();
        List<venta> listaVenta = new ArrayList<venta>();   //<venta>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql3);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            venta venta = new venta();

            venta.setId_venta(rs.getInt(1));
            venta.setDate_inicio(rs.getString(2));
            venta.setDate_fin(rs.getString(3));
            venta.setTotal(rs.getInt(4));

            listaVenta.add(venta);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaVenta;
    }

    //METODO DE ACTUALIZAR CLIENTES
    public boolean actualizarVenta(venta vent) throws SQLException {
        boolean resultado = false;
        String sql4 = "UPDATE venta SET date_inicio=?,date_fin=?,total=? WHERE id_venta = " + vent.getId_venta();
        /*
            UPDATE STRUTS2CRUD SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE UEMAIL=?";

         */
        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql4);

        pstInsert.setString(1, vent.getDate_inicio());     //
        pstInsert.setString(2, vent.getDate_fin());        //
        pstInsert.setInt(3, vent.getTotal());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE ELIMINAR CLIENTES
    public boolean eliminarVenta(venta vent) throws SQLException {
        String sql5 = "DELETE FROM venta WHERE id_venta =" + vent.getId_venta();
        //<venta>
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
