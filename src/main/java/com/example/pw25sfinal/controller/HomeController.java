package com.example.pw25sfinal.controller;


import com.example.pw25sfinal.model.Autor;
import com.example.pw25sfinal.model.AutorSalvarDTO;
import com.example.pw25sfinal.model.Users;
import com.example.pw25sfinal.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping(value = {"/home", ""})
public class HomeController {

    @Autowired
    LivroRepository livroRepository;

    @GetMapping(value = "")
    public String home(Model model, Principal principal){
        model.addAttribute("livros", livroRepository.findAllByUsers_Username(SecurityContextHolder.getContext().getAuthentication().getName()));
        return "home";
    }


    @PostMapping(value = "/autor")
    public String autor(Model model, @Valid AutorSalvarDTO autorSalvarDTO, BindingResult result){
        if(!result.hasErrors()){
            Autor autor = autorSalvarDTO.toAutor();
            Users user = new Users();
            user.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());

            model.addAttribute("livros", livroRepository.findAllByAutor_NomeAndUsers_Username(autor.getNome(),
                    SecurityContextHolder.getContext().getAuthentication().getName()));
        }

        return "home";
    }

}
