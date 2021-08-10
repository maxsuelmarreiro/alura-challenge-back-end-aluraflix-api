package com.maxsuel.api.model;

import javax.persistence.*;

@Entity
public class Video {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Categoria categoria;
    private String titulo;
    private String descricao;
    private String URL;


    public Video() {
    }

    public Video(String titulo, String descricao, String URL, Categoria categoria) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.URL = URL;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void atualizar(String titulo, String descricao, String url) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.URL = url;
    }
}
