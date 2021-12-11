package com.example.pw25sfinal.model;

import org.springframework.security.core.context.SecurityContextHolder;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;

public class LivroSalvarDTO {

    @NotBlank
    private String titulo;

    @DecimalMin(value = "0.0", inclusive = false)
    private BigDecimal valor;

    @NotBlank
    private String urlImagem;

    private String descricao;

    private String nomeAutor;

    public LivroSalvarDTO() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }


    public Livro toLivro(){
        Livro livro = new Livro();
        livro.setTitulo(titulo);
        livro.setValor(valor);
        livro.setUrlImagem(urlImagem);
        livro.setDescricao(descricao);
        Autor autor = new Autor();
        autor.setNome(nomeAutor);
        livro.setAutor(autor);


        return livro;
    }
}
