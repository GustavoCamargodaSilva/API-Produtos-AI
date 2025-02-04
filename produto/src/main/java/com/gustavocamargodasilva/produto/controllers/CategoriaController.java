package com.gustavocamargodasilva.produto.controllers;

import com.gustavocamargodasilva.produto.dto.CategoriaDTO;
import com.gustavocamargodasilva.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO = categoriaService.createCategoria(categoriaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(categoriaDTO);
    }
}