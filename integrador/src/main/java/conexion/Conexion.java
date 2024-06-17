package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    static final String USER="root";
    static final String PASSWORD="";
    static Connection connection=null;
    public  static Connection conectar(){


        try {
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/almacen",USER,PASSWORD);
            System.out.println("conexion");
        } catch (SQLException e) {
            System.out.println("error al conectar "+e.getMessage()+e.getClass());
        }
return connection;
    }


}
