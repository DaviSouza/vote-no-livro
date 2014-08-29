/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package voto.util;

/**
 *
 * @author Davi Souza
 */
public class Votados {

    private Integer votos;
    private String nome;
    private String url;

    public Votados(String nome, String url, Integer votos) {
        this.votos = votos;
        this.nome = nome;
        this.url = url;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
