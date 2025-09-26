package com.unincor.projetows.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.unincor.projetows.model.repository.ProdutoRepository;

@Controller
@RequestMapping("/produtos-site")
public class ProdutoControllerView {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("produtos", produtoRepository.findAll());
        return "produtos-site/lista";
        
    }
}
