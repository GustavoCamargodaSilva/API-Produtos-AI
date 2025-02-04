package com.gustavocamargodasilva.produto.repository;

import com.gustavocamargodasilva.produto.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}