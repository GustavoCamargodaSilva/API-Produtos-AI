package com.gustavocamargodasilva.produto.service;

import com.gustavocamargodasilva.produto.dto.CategoriaDTO;
import com.gustavocamargodasilva.produto.entities.Categoria;
import com.gustavocamargodasilva.produto.exception.ResourceNotFoundException;
import com.gustavocamargodasilva.produto.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

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

    @Transactional(readOnly = true)
    public List<CategoriaDTO> listarTodasCategorias() {

        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias.stream().map(CategoriaDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public CategoriaDTO buscarCategoriaPorId(Long id) {

        Categoria categoria = categoriaRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Categoria não encontrada"));

        return new CategoriaDTO(categoria);
    }
}