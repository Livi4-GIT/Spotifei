/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import SpotDAO.UsuarioDAO;
import java.sql.Connection;

public class LoginController {
    private UsuarioDAO usuariodao;
    
    public LoginController(Connection conn){
        this.usuariodao = new UsuarioDAO(conn);
       
    }
    public boolean fazerLogin(String nome, String senha){
        return usuariodao.buscarUsuario(nome,senha);
    }
    
   public boolean cadastrarUsuario(String nome, String senha){
       return usuariodao.cadastrarUsuario(nome,senha);
   }
}
