package dao;

import bean.caracteristicas;
import conexion.ConexionSQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CaractDAO {

    private String sql = "insert into Caracteristicas(marca,model,CPU,RAM,DD,TV,serie)values(?,?,?,?,?,?,?);";
    private String sql2 = "select * from Caracteristicas";

    //METODO DE INSERT CARACTERISTICA
    public boolean insertCaract(caracteristicas cara) throws SQLException {
        boolean resultado = false;

        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql);

        pstInsert.setString(1, cara.getMarca());
        pstInsert.setString(2, cara.getModel());
        pstInsert.setString(3, cara.getCpu());
        pstInsert.setString(4, cara.getRam());
        pstInsert.setString(5, cara.getDisco());
        pstInsert.setString(6, cara.getTv());
        pstInsert.setString(7, cara.getSerie());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }   //listo :D

    //METODO DE CONSULTAS CARACTERISTICAS
    public List<caracteristicas> consulta() throws SQLException {

        List<caracteristicas> listaCaract = new ArrayList<caracteristicas>();   //<caracteristicas>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql2);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            caracteristicas cara = new caracteristicas();

            cara.setId_car(rs.getInt(1));
            cara.setMarca(rs.getString(2));
            cara.setModel(rs.getString(3));
            cara.setCpu(rs.getString(4));
            cara.setRam(rs.getString(5));
            cara.setDisco(rs.getString(6));
            cara.setTv(rs.getString(7));
            cara.setSerie(rs.getString(8));

            listaCaract.add(cara);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaCaract;
    }

    //METODO DE BUSCAR
    public List<caracteristicas> buscarCaracteristica(caracteristicas carac) throws SQLException {

        String sql3 = "SELECT * FROM caracteristicas WHERE id_car =" + carac.getId_car();
        List<caracteristicas> listaCaract = new ArrayList<caracteristicas>();   //<>
        Connection conn = ConexionSQL.getConnection();
        PreparedStatement pstSelect = conn.prepareStatement(sql3);
        ResultSet rs = pstSelect.executeQuery();

        while (rs.next()) {

            caracteristicas cara = new caracteristicas();

            cara.setId_car(rs.getInt(1));
            cara.setMarca(rs.getString(2));
            cara.setModel(rs.getString(3));
            cara.setCpu(rs.getString(4));
            cara.setRam(rs.getString(5));
            cara.setDisco(rs.getString(6));
            cara.setTv(rs.getString(7));
            cara.setSerie(rs.getString(8));

            listaCaract.add(cara);
        }
        pstSelect.close();
        rs.close();
        conn.close();

        return listaCaract;
    }

    //METODO DE ACTUALIZAR
    public boolean actualizarCaracteristica(caracteristicas carac) throws SQLException {
        boolean resultado = false;
        String sql4 = "UPDATE caracteristicas SET marca=?,model=?,CPU=?,RAM=?,DD=?,TV=?,serie=? WHERE id_car = " + carac.getId_car();
        /*  marca,model,CPU,RAM,DD,TV,serie
            UPDATE STRUTS2CRUD SET UNAME=?,UEMAIL=?,UPASS=?,UDEG=? WHERE UEMAIL=?";
         */
        Connection con = ConexionSQL.getConnection();
        PreparedStatement pstInsert = con.prepareStatement(sql4);

        pstInsert.setString(1, carac.getMarca());
        pstInsert.setString(2, carac.getModel());
        pstInsert.setString(3, carac.getCpu());
        pstInsert.setString(4, carac.getRam());
        pstInsert.setString(5, carac.getDisco());
        pstInsert.setString(6, carac.getTv());
        pstInsert.setString(7, carac.getSerie());

        if (pstInsert.executeUpdate() == 1) {
            resultado = true;

            pstInsert.close();
            con.close();
        }
        return false;
    }

    //METODO DE ELIMINAR
    public boolean eliminarCaracteristica(caracteristicas carac) throws SQLException {
        String sql5 = "DELETE FROM caracteristicas WHERE id_car =" + carac.getId_car();
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
