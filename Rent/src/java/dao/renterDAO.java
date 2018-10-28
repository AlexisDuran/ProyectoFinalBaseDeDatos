package dao;

import bean.renter;
import conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class renterDAO {

    private String sql = "insert into renter(nombre,correo)values(?,?);";
    private String sql2 = "select * from renter";

    //METODO DE INSERT
    public boolean insertRenter(renter rent) throws SQLException {
        boolean resultado = false;

        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql);

        pstInsert.setString(1, rent.getNombre());
        pstInsert.setString(2, rent.getCorreo());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE CONSULTAS
    public List<renter> consulta() throws SQLException {

        List<renter> listaRenter = new ArrayList<renter>();   //<>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql2);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            renter rent = new renter();

            rent.setId_user(rs.getInt(1));
            rent.setNombre(rs.getString(2));
            rent.setCorreo(rs.getString(3));

            listaRenter.add(rent);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaRenter;
    }

    //METODO DE BUSCAR
    public List<renter> buscarRenter(renter rent) throws SQLException {

        String sql3 = "SELECT * FROM renter WHERE id_user =" + rent.getId_user();
        List<renter> listaRenter = new ArrayList<renter>();   //<>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql3);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            renter renter = new renter();

            renter.setId_user(rs.getInt(1));
            renter.setNombre(rs.getString(2));
            renter.setCorreo(rs.getString(3));

            listaRenter.add(renter);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaRenter;
    }

    //METODO DE ACTUALIZAR
    public boolean actualizarRenter(renter rent) throws SQLException {
        boolean resultado = false;
        String sql4 = "UPDATE renter SET nombre=?,correo=? WHERE id_user = " + rent.getId_user();
        /*
            UPDATE STRUTS2CRUD SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE UEMAIL=?";

         */
        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql4);

        pstInsert.setString(1, rent.getNombre());
        pstInsert.setString(2, rent.getCorreo());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE ELIMINAR
    public boolean eliminarRenter(renter rent) throws SQLException {
        String sql5 = "DELETE FROM renter WHERE id_user =" + rent.getId_user();
        //<>
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
