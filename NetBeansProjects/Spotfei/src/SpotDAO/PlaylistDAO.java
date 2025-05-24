/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpotDAO;

/**
 *
 * @author GAMER 2.0
 */

import Model.Playlist_Model;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlaylistDAO {
    private Connection conn;

    public PlaylistDAO(Connection conn) {
        this.conn = conn;
    }

    // Inserir nova playlist
    public void inserir(Playlist_Model playlist) throws SQLException {
        String sql = "INSERT INTO Playlists (nome_playlist, id_usuario) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setString(1, playlist.getNomePlaylist());
        stmt.setInt(2, playlist.getIdUsuario());
        stmt.executeUpdate();
        stmt.close();
    }

    // Buscar playlists por usuário
    public List<Playlist_Model> buscarPorUsuario(int idUsuario) throws SQLException {
        List<Playlist_Model> playlists = new ArrayList<>();
        String sql = "SELECT * FROM Playlists WHERE id_usuario = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idUsuario);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Playlist_Model playlist = new Playlist_Model();
            playlist.setNomePlaylist(rs.getString("nome_playlist"));
            playlists.add(playlist);
        }

        stmt.close();
        return playlists;
    }

    // Adicionar música à playlist (associação na tabela Playlist_Musica)
    public void adicionarMusica(int idPlaylist, int idMusica) throws SQLException {
        String sql = "INSERT INTO Playlist_Musica (id_playlist, id_musica) VALUES (?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, idPlaylist);
        stmt.setInt(2, idMusica);
        stmt.executeUpdate();
        stmt.close();
    }

    // Remover playlist
    public void remover(int idPlaylist) throws SQLException {
        // Remove da tabela associativa primeiro
        PreparedStatement stmt1 = conn.prepareStatement("DELETE FROM Playlist_Musica WHERE id_playlist = ?");
        stmt1.setInt(1, idPlaylist);
        stmt1.executeUpdate();
        stmt1.close();

        // Depois remove a playlist
        PreparedStatement stmt2 = conn.prepareStatement("DELETE FROM Playlists WHERE id_playlist = ?");
        stmt2.setInt(1, idPlaylist);
        stmt2.executeUpdate();
        stmt2.close();
    }
}
