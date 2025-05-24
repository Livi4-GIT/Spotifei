/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SpotDAO;
import Model.Musica_Model;
import Model.Artista_Model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;


public class MusicaDAO {
    private Connection conn;
    
    public MusicaDAO(Connection conn) {
        this.conn = conn;
    }
    
    public ResultSet consultar(Musica_Model musica, Artista_Model artista) throws SQLException{
        String sql = "select * from musicas where nome_musica = ? and nome_artista = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, musica.getNome_musica());
        statement.setString(2, artista.getNome());
        statement.execute();
        ResultSet resultado = statement.getResultSet();
        return resultado;
        
    }
    
    public void inserir(Musica_Model musica, Artista_Model artista) throws SQLException{
        String sql = "insert into musicas (nome-musica, nome_artista) values ('" +
                    musica.getNome_musica() + "','" +
                    musica.getNome() + "')";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.execute();

    }
    
    public void atualizar(Musica_Model musica, Artista_Model artista) throws SQLException{
        String sql = "update musicas set nome_musica = ? where nome_artista = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, musica.getNome_musica());
        statement.setString(2, artista.getNome());
        statement.execute();

    }
    
    public void remover(Musica_Model musica) throws SQLException{
        String sql = "delete from musicas where nome_musica = ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, musica.getNome_musica());
        statement.execute();

        
    }
}