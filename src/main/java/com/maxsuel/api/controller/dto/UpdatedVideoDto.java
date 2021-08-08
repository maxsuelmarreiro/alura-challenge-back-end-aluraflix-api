package com.maxsuel.api.controller.dto;

import com.maxsuel.api.model.Video;

import java.util.List;
import java.util.stream.Collectors;

public class UpdatedVideoDto {

    private Long id;
    private String titulo;
    private String descricao;
    private String URL;

    public UpdatedVideoDto(Video video) {
        this.id = video.getId();
        this.titulo = video.getTitulo();
        this.descricao = video.getDescricao();
        this.URL = video.getURL();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getURL() {
        return URL;
    }

    public static List<UpdatedVideoDto> converter(List<Video> videos) {
        return videos.stream().map(UpdatedVideoDto::new).collect(Collectors.toList());
    }
}
