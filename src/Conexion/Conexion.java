package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public  class Conexion {

	public static Connection getConectar(){
        Connection cn=null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=PPAIDSI;integratedSecurity=true");
            System.out.println("Conexion Exitosa");
        } 
        catch (Exception e) {
            //e.printStackTrace();
            System.out.println("ERROR "+e.getMessage());
        }
        return cn;
    }
}
