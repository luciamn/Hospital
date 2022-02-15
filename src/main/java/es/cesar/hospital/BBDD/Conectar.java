package es.cesar.hospital.BBDD;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conectar {

    public static final String URL = "jdbc:mysql://localhost:3306/hospital";
    public static final String USER = "root";
    public static final String CLAVE = "admin";

    public Connection getConexion(){
        Connection con = null;
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(URL, USER, CLAVE);
        }catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
        return con;
    }
}
