package dataSource;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class Conexion {
    private final Dotenv dotenv = Dotenv.load();
    private final String URL = dotenv.get("DB_URL");
    private final String USER = dotenv.get("DB_USER");
    private final String PASSWORD = dotenv.get("DB_PASSWORD");

    public static Conexion instancia;
    public Connection conexion;

    private Conexion() {}

    public Connection conectar() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            this.conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            return conexion;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void desconectar() {
        try {
            if (conexion != null) conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public synchronized static Conexion getInstancia() {
        if (instancia == null) {
            instancia = new Conexion();
        }
        return instancia;
    }
}
