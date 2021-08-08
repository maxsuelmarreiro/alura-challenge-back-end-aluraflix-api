package com.maxsuel.api.controller;

import com.maxsuel.api.controller.dto.UpdatedVideoDto;
import com.maxsuel.api.controller.dto.VideoDto;
import com.maxsuel.api.controller.form.UpdateVideoForm;
import com.maxsuel.api.controller.form.VideoForm;
import com.maxsuel.api.service.VideoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/videos")
public class VideosController {

    public final VideoService videoService;

    public VideosController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<VideoDto>> getAllVideos() {
        return videoService.getAllVideos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VideoDto> getVideoById(@PathVariable("id") Long id) {
        return videoService.getVideoById(id);
    }

    @PostMapping()
    public ResponseEntity<VideoDto> saveVideo(@RequestBody @Valid VideoForm videoForm, UriComponentsBuilder uriBuilder) {
        return videoService.saveVideo(videoForm, uriBuilder);
    }

    @PutMapping
    public ResponseEntity<UpdatedVideoDto> updateVideo(@RequestBody @Valid UpdateVideoForm updateVideoForm) {
        return videoService.updateVideo(updateVideoForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVideo(@PathVariable("id") Long id) {
        return videoService.deleteVideoById(id);
    }
}
