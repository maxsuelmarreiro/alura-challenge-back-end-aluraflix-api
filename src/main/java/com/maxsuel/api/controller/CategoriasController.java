package com.maxsuel.api.controller;

import com.maxsuel.api.controller.dto.CategoriaDto;
import com.maxsuel.api.controller.dto.UpdatedCategoriaDto;
import com.maxsuel.api.controller.form.CategoriaForm;
import com.maxsuel.api.controller.form.UpdateCategoriaForm;
import com.maxsuel.api.service.CategoriaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {

    private final CategoriaService categoriaService;

    public CategoriasController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDto>> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDto> getCategoriaById(@PathVariable("id") Long id) {
        return categoriaService.getCategoriaById(id);
    }

    @PostMapping
    public ResponseEntity<CategoriaDto> saveCategoria(@Valid @RequestBody CategoriaForm categoriaForm, UriComponentsBuilder uriBuilder) {
        return categoriaService.saveCategoria(categoriaForm, uriBuilder);
    }

    @PutMapping
    public ResponseEntity<UpdatedCategoriaDto> updateCategoria(@Valid @RequestBody UpdateCategoriaForm categoriaForm) {
        return categoriaService.updateCategoria(categoriaForm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable("id") Long id) {
        return categoriaService.deleteCategoriaById(id);
    }
}
