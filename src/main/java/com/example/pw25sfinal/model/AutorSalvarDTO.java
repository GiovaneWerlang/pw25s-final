package com.example.pw25sfinal.model;

import javax.validation.constraints.NotBlank;

public class AutorSalvarDTO {

    @NotBlank
    private String nome;

    public AutorSalvarDTO() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Autor toAutor(){
        Autor autor = new Autor();
        autor.setNome(nome);

        return autor;
    }
}

