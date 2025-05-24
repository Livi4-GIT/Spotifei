/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.time.LocalDateTime;

/**
 *
 * @author GAMER 2.0
 */
public class Historico_Model {
    private int idUsuario;
    private String tBusca;
    private LocalDateTime dataHora;

    public Historico_Model() {
    }

    public Historico_Model(int idUsuario, String tBusca, LocalDateTime dataHora) {
        this.idUsuario = idUsuario;
        this.tBusca = tBusca;
        this.dataHora = dataHora;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String gettBusca() {
        return tBusca;
    }

    public void settBusca(String tBusca) {
        this.tBusca = tBusca;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(LocalDateTime dataHora) {
        this.dataHora = dataHora;
    }
    
    
}
