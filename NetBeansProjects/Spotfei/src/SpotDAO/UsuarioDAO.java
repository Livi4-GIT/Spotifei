/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpotDAO;

import model.Usuario_Model;
import java.sql.*;

public class UsuarioDAO {

    private Connection conn;


    public UsuarioDAO() throws SQLException {
        this.conn = Conexao.getConexao();
    }

    public Usuario_Model buscarUsuario(String nome, String senha) throws SQLException {
        String sql = "SELECT u.ID_Usuario, p.Nome, p.Senha FROM Usuarios u JOIN Pessoas p ON u.ID_Pessoa = p.ID_Pessoa WHERE p.Nome = ? AND p.Senha = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2, senha);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return new Usuario_Model(
                rs.getInt("ID_Usuario"),
                rs.getString("Nome"),
                rs.getString("Senha")
            );
        }
        return null;
    }

    public void cadastrarUsuario(Usuario_Model usuario) throws SQLException {
        // 1. Inserir em Pessoas
        String sqlPessoa = "INSERT INTO Pessoas (Nome, Senha) VALUES (?, ?) RETURNING ID_Pessoa";
        PreparedStatement stmtPessoa = conn.prepareStatement(sqlPessoa);
        stmtPessoa.setString(1, usuario.getNome());
        stmtPessoa.setString(2, usuario.getSenha());
        ResultSet rs = stmtPessoa.executeQuery();
        if (rs.next()) {
            int idPessoa = rs.getInt("ID_Pessoa");

            // 2. Inserir em Usuarios
            String sqlUsuario = "INSERT INTO Usuarios (ID_Pessoa) VALUES (?)";
            PreparedStatement stmtUsuario = conn.prepareStatement(sqlUsuario);
            stmtUsuario.setInt(1, idPessoa);
            stmtUsuario.executeUpdate();
        }
    }
}