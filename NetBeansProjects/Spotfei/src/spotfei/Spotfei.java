/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package spotfei;

import Controller.LoginController;
import SpotDAO.Conexao;
import Views.LoginViews;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author uniflseveri
 */
public class Spotfei {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = Conexao.getConnection();
        
        LoginController loginController = new LoginController(conn);
        
        java.awt.EventQueue.invokeLater(()->{
            new Login(loginController,LoginController,Connection conn).setVisible(true);
        });
      }
    
}
