package com.example.pw25sfinal.controller;

import com.example.pw25sfinal.model.Livro;
import com.example.pw25sfinal.model.LivroSalvarDTO;
import com.example.pw25sfinal.model.Users;
import com.example.pw25sfinal.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/livro")
public class LivroController {

    LivroRepository livroRepository;

    @Autowired
    public LivroController(LivroRepository livroRepository) {
        Assert.notNull(livroRepository,"LivroRepository null in LivroController");

        this.livroRepository = livroRepository;
    }

    @RequestMapping("/novo")
    public String novoLivro(LivroSalvarDTO livroSalvarDTO){
        return "livro/formulario";
    }

    @PostMapping(value = "/salvar")
    public String salvarLivro(@Valid LivroSalvarDTO livroSalvarDTO, BindingResult result){

        Users user = new Users();
        user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(user.getUsername()));


        Livro livro = livroSalvarDTO.toLivro();
        livro.setUsers(user);

        if(!result.hasErrors()){
            livroRepository.save(livro);
        }

        return "redirect:/home";
    }

}
