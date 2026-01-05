package config;

import java.sql.*;

public class Koneksi {
    
    public Connection koneksi;
    public Statement stmt;
    public PreparedStatement pstmt;
    
    public Koneksi() {
        String url = "jdbc:mysql://localhost:3306/toko_nawir";
        String user = "root";
        String password = "";
        
        try {
            koneksi = DriverManager.getConnection(url, user, password);
//            System.out.println("Koneksi Berhasil!");
        } catch (Exception e) {
            System.out.println("Ada Masalah!");
        }
    }
    
    public Statement createStatement() throws SQLException {
        return stmt = koneksi.createStatement(
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
    }
    
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return pstmt = koneksi.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_READ_ONLY
        );
        
    }
}
