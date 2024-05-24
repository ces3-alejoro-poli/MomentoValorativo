package co.edu.poli.ces3.momentovalorativo.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionMySQL {

    private int port;
    private String host;
    private String user;
    private String password;
    private String dataBaseName;
    public static final long SERIAL = 1L;

    private Connection cnn;
    public conexionMySQL(String host){
        user = "root";
        password = "";
        this.port = 3307;
        this.host= host != null ? host : "127.0.0.1";
        this.dataBaseName = "examen-ces3";
    }


    public void disconect() throws SQLException {
        if(cnn != null)
            cnn.close();
    }
    public Connection conexion(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            cnn = DriverManager.getConnection( "jdbc:mysql://" +host+":"+port+"/"+ dataBaseName, user, password);
            return cnn;
        }catch (ClassNotFoundException | SQLException exception){
            System.out.println(exception.getMessage());
            exception.printStackTrace();
        }
        return null;
    }

}
