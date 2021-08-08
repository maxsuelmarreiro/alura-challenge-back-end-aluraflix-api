package com.maxsuel.api.controller.dto;

import com.maxsuel.api.model.Categoria;

public class UpdatedCategoriaDto {

    private Long id;
    private String titulo;
    private String cor;

    public UpdatedCategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.titulo = categoria.getTitulo();
        this.cor = categoria.getCor();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCor() {
        return cor;
    }
}
