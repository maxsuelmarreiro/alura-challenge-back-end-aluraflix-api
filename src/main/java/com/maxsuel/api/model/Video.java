package com.maxsuel.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private String URL;


    public Video() {
    }

    public Video(String titulo, String descricao, String URL) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.URL = URL;
    }

    public Video(String titulo, String URL) {
        this.titulo = titulo;
        this.URL = URL;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void atualizar(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.URL = url;
    }
}
