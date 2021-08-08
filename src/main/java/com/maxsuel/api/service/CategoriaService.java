package com.maxsuel.api.service;

import com.maxsuel.api.controller.dto.CategoriaDto;
import com.maxsuel.api.controller.dto.UpdatedCategoriaDto;
import com.maxsuel.api.controller.form.CategoriaForm;
import com.maxsuel.api.controller.form.UpdateCategoriaForm;
import com.maxsuel.api.model.Categoria;
import com.maxsuel.api.repository.CategoriaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    public final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        return ResponseEntity.ok(CategoriaDto.converter(categoriaRepository.findAll()));

    }

    public ResponseEntity<CategoriaDto> getCategoriaById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        return categoria.map(value -> ResponseEntity.ok(new CategoriaDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Transactional
    public ResponseEntity<CategoriaDto> saveCategoria(CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder) {
        Categoria categoria = categoriaForm.converter();
        categoriaRepository.save(categoria);

        URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
    }

    @Transactional
    public ResponseEntity<UpdatedCategoriaDto> updateCategoria(UpdateCategoriaForm categoriaForm) {
        Optional<Categoria> categoria = categoriaRepository.findById(categoriaForm.getId());

        if (categoria.isPresent()) {
            categoria.get().atualizar(categoriaForm.getTitulo(), categoriaForm.getCor());
            return ResponseEntity.ok().body(new UpdatedCategoriaDto(categoria.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @Transactional
    public ResponseEntity<Void> deleteCategoriaById(Long id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if (categoria.isPresent()) {
            categoriaRepository.delete(categoria.get());
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
