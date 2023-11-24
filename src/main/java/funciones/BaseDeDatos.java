package funciones;

import java.sql.*;
import javax.swing.*;

public class BaseDeDatos {
	
    //Conector a la base de datos
    private static Statement statementConexion;

    //Constructor estático de la clase
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/javayendry", "root", "");
            statementConexion = conexion.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static ResultSet RealizarConsultaLectura (String sql) throws SQLException {
        return statementConexion.executeQuery(sql);
    }

    public static void RealizarConsultaEscritura(String sql) throws SQLException {
        statementConexion.executeUpdate(sql);
    }	
}