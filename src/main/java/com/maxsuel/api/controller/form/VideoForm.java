package com.maxsuel.api.controller.form;

import com.maxsuel.api.model.Video;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class VideoForm {

    @NotNull @NotEmpty @Length(min = 5)
    private String titulo;
    @NotEmpty
    private String descricao;
    @NotNull @NotEmpty @URL
    private String url;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Video converter() {
        return new Video(titulo, descricao, url);
    }
}
