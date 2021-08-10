package com.maxsuel.api.service;

import com.maxsuel.api.controller.dto.UpdatedVideoDto;
import com.maxsuel.api.controller.dto.VideoDto;
import com.maxsuel.api.controller.form.UpdateVideoForm;
import com.maxsuel.api.controller.form.VideoForm;
import com.maxsuel.api.model.Categoria;
import com.maxsuel.api.model.Video;
import com.maxsuel.api.repository.CategoriaRepository;
import com.maxsuel.api.repository.VideoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class VideoService {

    private final VideoRepository videoRepository;
    private final CategoriaRepository categoriaRepository;

    public VideoService(VideoRepository videoRepository, CategoriaRepository categoriaRepository) {
        this.videoRepository = videoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public ResponseEntity<List<VideoDto>> getAllVideos() {
        return ResponseEntity.ok(VideoDto.converter(videoRepository.findAll()));
    }

    public ResponseEntity<VideoDto> getVideoById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        return video.map(value -> ResponseEntity.ok(new VideoDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<VideoDto> saveVideo(VideoForm videoForm, UriComponentsBuilder uriBuilder) {
        Video video = new Video();
        video.setTitulo(videoForm.getTitulo());
        video.setDescricao(videoForm.getDescricao());
        video.setURL(videoForm.getUrl());

        Optional<Categoria> categoria = categoriaRepository.findById(videoForm.getCategoriaId());

        if (categoria.isPresent()){
            video.setCategoria(categoria.get());
        }else{
            Optional<Categoria> auxCategoria = categoriaRepository.findById(1L);
            auxCategoria.ifPresent(video::setCategoria);
        }

        videoRepository.save(video);

        URI uri = uriBuilder.path("/videos/{id}").buildAndExpand(video.getId()).toUri();
        return ResponseEntity.created(uri).body(new VideoDto(video));
    }

    @Transactional
    public ResponseEntity<UpdatedVideoDto> updateVideo(UpdateVideoForm updateVideoForm) {
        Optional<Video> video = videoRepository.findById(updateVideoForm.getId());

        if (video.isPresent()) {
            video.get().atualizar(updateVideoForm.getTitulo(), updateVideoForm.getDescricao(), updateVideoForm.getUrl());
            return ResponseEntity.ok().body(new UpdatedVideoDto(video.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<Void> deleteVideoById(Long id) {
        Optional<Video> video = videoRepository.findById(id);
        if (video.isPresent()) {
            videoRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
