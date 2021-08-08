package com.maxsuel.api.controller.dto;

import com.maxsuel.api.model.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public class CategoriaDto {
    private Long id;
    private String titulo;
    private String cor;

    public CategoriaDto(Categoria categoria) {
        this.id = categoria.getId();
        this.titulo = categoria.getTitulo();
        this.cor = categoria.getCor();
    }

    public static List<CategoriaDto> converter(List<Categoria> categorias) {
        return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
    }

    public String getTitulo() {
        return titulo;
    }
    public String getCor() {
        return cor;
    }
    public Long getId() {
        return id;
    }
}
