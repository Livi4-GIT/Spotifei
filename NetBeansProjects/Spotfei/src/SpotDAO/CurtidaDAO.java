/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpotDAO;
import Model.Curtida_Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author GAMER 2.0
 */

public class CurtidaDAO {
    private Connection conn;

    public CurtidaDAO(Connection conn) {
        this.conn = conn;
    }
    
   //CURTIR
    public void curirMusica(int idUsuario, int idMusica) throws SQLException{
     
        
    }
}
