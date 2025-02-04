package com.gustavocamargodasilva.produto.service;

import com.gustavocamargodasilva.produto.dto.CategoriaDTO;
import com.gustavocamargodasilva.produto.entities.Categoria;
import com.gustavocamargodasilva.produto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        Categoria categoria = new Categoria();
        categoria.setNome(categoriaDTO.getNome());
        categoria = categoriaRepository.save(categoria);
        return new CategoriaDTO(categoria);
    }
}