package view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import model.*;
import java.util.*;
public class MailListReaderBD {
    static public List<Mail>list=new ArrayList<>();
    private static Connection connect() {
        Connection conn = null;
        try {
            
            System.out.println("try");
            String url = "jdbc:sqlite:C:\\Users\\thanq\\Desktop\\Kata5P2IS2\\mail.db";
            conn = DriverManager.getConnection(url);
            selectAll(conn);
            System.out.println("Connexión a SQLite establecida");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return conn;
    }
    private static void selectAll(Connection conn){
        String sql = "SELECT * FROM direcc_email";
        try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" +
                rs.getString("direccion") + "\t");
                read(rs.getString("direccion"));
                
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private static void read(String dir){
        list.add(new Mail(dir));
    }
    public static void execute(){
        connect();
    }
    
}
