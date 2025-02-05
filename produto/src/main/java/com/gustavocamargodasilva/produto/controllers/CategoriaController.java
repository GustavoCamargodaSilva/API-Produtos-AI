package com.gustavocamargodasilva.produto.controllers;

import com.gustavocamargodasilva.produto.dto.CategoriaDTO;
import com.gustavocamargodasilva.produto.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping("/cadastrar")
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        categoriaDTO = categoriaService.createCategoria(categoriaDTO);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(categoriaDTO.getId()).toUri();

        return ResponseEntity.created(uri).body(categoriaDTO);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CategoriaDTO>> listarTodasCategorias(){
        List<CategoriaDTO> categorias = categoriaService.listarTodasCategorias();
        return ResponseEntity.ok().body(categorias);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<CategoriaDTO> buscarCategoriaPorId(@PathVariable Long id){
        CategoriaDTO categoriaDTO = categoriaService.buscarCategoriaPorId(id);
        return ResponseEntity.ok().body(categoriaDTO);
    }


}