/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class Musica_Model {
    private String nome_musica; 
    private Artista_Model nome;

    public Musica_Model(String nome_musica, Artista_Model nome) {
        this.nome_musica = nome_musica;
        this.nome = nome;
    }

    public Musica_Model() {
    }

    public String getNome_musica() {
        return nome_musica;
    }

    public void setNome_musica(String nome_musica) {
        this.nome_musica = nome_musica;
    }

    public Artista_Model getNome() {
        return nome;
    }

    public void setNome(Artista_Model nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Musica_Model{" + "nome_musica=" + nome_musica + ", nome=" + nome + '}';
    }

    

   
}
