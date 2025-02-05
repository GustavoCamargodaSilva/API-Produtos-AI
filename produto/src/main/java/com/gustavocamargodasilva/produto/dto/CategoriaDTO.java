package com.gustavocamargodasilva.produto.dto;

import com.gustavocamargodasilva.produto.entities.Categoria;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;


public class CategoriaDTO {

    private Long id;

    @NotNull(message = "Campo obrigatório")
    @Size(min = 1, max = 20, message = "O campo deve ter entre 1 e 80 caracteres")
    private String nome;

    public CategoriaDTO() { }

    public CategoriaDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoriaDTO(Categoria entity) {
        id = entity.getId();
        nome = entity.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}