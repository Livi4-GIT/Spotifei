/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpotDAO;

/**
 *
 * @author GAMER 2.0
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDAO {
    private Connection conn;

    public HistoricoDAO(Connection conn) {
        this.conn = conn;
    }

    public void registrarPesquisa(int idUsuario, String termo) throws SQLException {
        String sql = "INSERT INTO Historico_Pesquisa (id_usuario, termo_pesquisa) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        stmt.setString(2, termo);
        stmt.executeUpdate();
        stmt.close();
    }

    public List<String> buscarUltimosTermos(int idUsuario) throws SQLException {
        List<String> termos = new ArrayList<>();
        String sql = """
            SELECT termo_pesquisa FROM Historico_Pesquisa
            WHERE id_usuario = ?
            ORDER BY data_pesquisa DESC
            LIMIT 10
        """;
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            termos.add(rs.getString("termo_pesquisa"));
        }

        stmt.close();
        return termos;
    }
}
