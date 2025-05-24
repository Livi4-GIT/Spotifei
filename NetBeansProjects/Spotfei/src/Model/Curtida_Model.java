/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author GAMER 2.0
 */
public class Curtida_Model {
    private int idusuario;
    private String nomemusica;

    public Curtida_Model() {
    }

    public Curtida_Model(int idusuario, String nomemusica) {
        this.idusuario = idusuario;
        this.nomemusica = nomemusica;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNomeMusica() {
        return nomemusica;
    }

    public void setNomeMusica(String nomemusica) {
        this.nomemusica = nomemusica;
    }
    
    
}
