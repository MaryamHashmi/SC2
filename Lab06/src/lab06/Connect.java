package lab06;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect {
    public static void connect (){
        String URL="jdbc:mysql//localhost/dblab5";
        String USER="root";
        String PASSWORD="seecs@123";
        String DRIVER_CLASS="com.mysql.jdbc.Driver";
        try{
            Class.forName(DRIVER_CLASS);
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        }
        Connection conn=null;
        try{
            conn=DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(SQLException e)
        {
            System.out.println("ERROR: Unble to connect");
        }
        System.out.println("Connected");
        }
}
