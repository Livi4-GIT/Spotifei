/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;


/**
 *
 * @author uniflseveri
 */
public class Playlist_Model {
    private String nomePlaylist;
    private int idUsuario;
    private ArrayList<Musica_Model> musicas;

    public Playlist_Model() {
    }

    public Playlist_Model(String nomePlaylist, int idUsuario, ArrayList<Musica_Model> musicas) {
        this.nomePlaylist = nomePlaylist;
        this.idUsuario = idUsuario;
        this.musicas = musicas;
    }

    public String getNomePlaylist() {
        return nomePlaylist;
    }

    public void setNomePlaylist(String nomePlaylist) {
        this.nomePlaylist = nomePlaylist;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public ArrayList<Musica_Model> getMusicas() {
        return musicas;
    }

    public void setMusicas(ArrayList<Musica_Model> musicas) {
        this.musicas = musicas;
    }

   
}
