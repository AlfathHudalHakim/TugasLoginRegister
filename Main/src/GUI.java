/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/**
 *
 * @author LENOVO
 */
public class GUI extends JFrame{
    JLabel LabJudul = new JLabel("DAFTAR");
    JLabel LabReg = new JLabel ("Username : ");
    JTextField FldReg = new JTextField (20);
    JLabel LabRPass = new JLabel ("Password : ");
    JPasswordField FldRPass = new JPasswordField (10);
    JButton ButReg = new JButton ("Daftar");
    JLabel LabJudul2 = new JLabel("lOGIN");
    JLabel LabUsername = new JLabel("Username : ");
    JTextField FldUsername = new JTextField (20);
    JLabel LabPass = new JLabel ("Password : ");
    JPasswordField FldPass = new JPasswordField(10);
    JButton ButLogin = new JButton("Login");

    
    public GUI(){
        setVisible(true);
        setTitle("");
        setSize(325,400);
        setLayout(null);
        add(LabJudul); 
        add(LabReg);
        add(FldReg);
        add(LabRPass);
        add(FldRPass);
        add(ButReg);
        
        add(LabJudul2); 
        add(LabUsername);
        add(FldUsername);
        add(LabPass);
        add(FldPass);
        add(ButLogin);

        LabJudul.setBounds(125, 0, 100,30);
        LabReg.setBounds(30, 40, 100,30);
        FldReg.setBounds(120,40,150,30);
        LabPass.setBounds(30,80,100,30);
        FldPass.setBounds(120,80,150,30);
        ButReg.setBounds(100,150,90,20);
        
        LabJudul2.setBounds(125, 180, 100,30);
        LabUsername.setBounds(30,220,100,30);
        FldUsername.setBounds(120,220,150,30);
        LabRPass.setBounds(30,260,100,30);
        FldRPass.setBounds(120,260,150,30);
        ButLogin.setBounds(100,330,90,20);
        
        ButReg.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector conn = new Connector();
                String userdaf = FldReg.getText();
                String passdaf = String.valueOf(FldRPass.getPassword());
                if (!userdaf.isEmpty() && !passdaf.isEmpty()) {
                    conn.Logindat(userdaf,passdaf);
                    JOptionPane.showMessageDialog(null, "Pendaftaran berhasil!");
                }
                else if (userdaf.isEmpty() || passdaf.isEmpty()) { 
                    JOptionPane.showMessageDialog(null, "Silahkan isi username & password terlebih dahulu!");
                }
            }
        });
        
        ButLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connector conn = new Connector();
                String user = FldUsername.getText();
                System.out.println(user);
                if (conn.namaCek(user) && user != "" && conn.Logincek(user, String.valueOf(FldPass.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil!");
                }
                else if (user.isEmpty() || String.valueOf(FldPass.getPassword()).isEmpty()) { 
                    JOptionPane.showMessageDialog(null, "Silahkan isi username & password terlebih dahulu!");
                }
                else if (!conn.namaCek(user)) {
                    JOptionPane.showMessageDialog(null, "Username tidak tersedia!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password salah!");
                }
                
            }
            
        });
        
    }
    
}
