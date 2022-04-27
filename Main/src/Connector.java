/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author LENOVO
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/tugasjdbc";
    String DBusername = "root";
    String DBpassword = "";
    
    String data[] = new String[2];
    Connection conn;
    Statement statement;
    static String[] username;
    public Connector() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl,DBusername,DBpassword);
        }catch(Exception ex){
            System.out.println("Koneksi Gagal " + ex.getMessage() );
        }
    }
    
    void Logindat (String username, String password){
        try {
            if (!namaCek(username)) {
                String query = "INSERT INTO `users` (`username`, `password`)" + "VALUES('" + username + "','" + password + "')";
                statement = conn.createStatement();
                statement.executeUpdate(query);
                System.out.println("Input Berhasil!");
                JOptionPane.showMessageDialog(null, "Pendaftaran Berhasil!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Username sudah ada!");
            }
        }catch (Exception ex) {
            System.out.println("Input Gagal");
        }
    }
    
    boolean namaCek (String username){
        try {
            String query = "SELECT * FROM `users` WHERE username = '"+username+"'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            
            while(resultSet.next()){
                data[0] = resultSet.getString("username");
            }
            statement.close();
            data[0].toString();
            return true;
        }catch (Exception e){
            System.out.println("Tidak Tersedia");
            return false;
        }
    }
    
    
    boolean Logincek (String username, String password){
        try {
            String query = "SELECT * FROM `users` WHERE username='"+username+"'";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                data[0] = resultSet.getString("username");
                data[1] = resultSet.getString("password");
            }
            statement.close();
            System.out.println(data[1].toString());
            System.out.println(password);
            if (data[1].toString().equals(password)) {
                return true;
            }
            else{
                return false;
            }
        }catch (Exception e){
            System.out.println("Tidak Tersedia!");
            return false;
        }
    }
}
