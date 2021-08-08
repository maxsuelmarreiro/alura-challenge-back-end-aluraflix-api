package com.maxsuel.api.controller.form;

import com.maxsuel.api.model.Categoria;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;

public class CategoriaForm {

    @NotEmpty
    private String titulo;
    @NotEmpty @Length(min = 4) @Length(max = 7)
    private String cor;

    public String getTitulo() {
        return titulo;
    }

    public String getCor() {
        return cor;
    }

    public Categoria converter() {
        return new Categoria(titulo, cor);
    }
}
