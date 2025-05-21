/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
/**
 *
 * @author uniflseveri
 */
public class Playlist_Model {
    private String nome_playlist;
    private Musica_Model nome_musica;

    public Playlist_Model(String nome_playlist, Musica_Model nome_musica) {
        this.nome_playlist = nome_playlist;
        this.nome_musica = nome_musica;
    }

    public Playlist_Model() {
    }

    public String getNome_playlist() {
        return nome_playlist;
    }

    public void setNome_playlist(String nome_playlist) {
        this.nome_playlist = nome_playlist;
    }

    public Musica_Model getNome_musica() {
        return nome_musica;
    }

    public void setNome_musica(Musica_Model nome_musica) {
        this.nome_musica = nome_musica;
    }

    @Override
    public String toString() {
        return "Playlist_Model{" + "nome_playlist=" + nome_playlist + ", nome_musica=" + nome_musica + '}';
    }
    
    
}
