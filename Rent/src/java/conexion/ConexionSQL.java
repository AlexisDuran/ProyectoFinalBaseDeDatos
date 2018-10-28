package conexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

public class ConexionSQL {

    private static final String ipAddress = "localhost"; //nota: localhost= 127.0.0.1
    private static final String dbName = "Rent"; //Nombre de tu base de datos
    private static final String user = "sa";//Nombre del usuario que utilizas en SQL SERVER
    private static final String password = "123";//Contraseña con el que ingresar al SQL Server
    private static final String service = "1433";

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //
        String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
        return DriverManager.getConnection(url, user, password);
        //----------------------------------------------------------------//

    }

    public static void main(String[] args) throws SQLException {
        Connection con = ConexionSQL.getConnection();
        if (con != null) {
            System.out.println("Conexión exitosa");
        }
    }
}
