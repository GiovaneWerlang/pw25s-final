package com.example.pw25sfinal.repository;


import com.example.pw25sfinal.model.Autor;
import com.example.pw25sfinal.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {

//    public List<Livro> findAllByTitulo(String titulo);
//
//    @Query("SELECT l FROM Livro l WHERE l.autor.nome like %:autor%")
//    public List<Livro> findAllByAutor_Nome(@Param("autor") String nome);

    @Query("SELECT l FROM Livro l JOIN fetch l.users u WHERE u.username = :username")
    public List<Livro> findAllByUsers_Username(@Param("username") String username);

    @Query("SELECT l FROM Livro l JOIN fetch l.users u WHERE l.autor.nome like %:autor% and u.username = :username")
    public List<Livro> findAllByAutor_NomeAndUsers_Username(@Param("autor") String nome, @Param("username") String username);
}