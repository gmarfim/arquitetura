package com.seuProjeto.controller;

import com.seuProjeto.service.CorretorService;
import com.seuProjeto.model.Corretor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CorretorController {
    private CorretorService corretorService;

    public CorretorController() {
        this.corretorService = new CorretorService();
    }

    @GetMapping("/loginCorretor")
    public String loginCorretor(@RequestParam("email") String email, @RequestParam("senha") String senha, Model model) {
        Corretor corretor = corretorService.buscarCorretorPorEmailESenha(email, senha);
        if (corretor != null) {
            model.addAttribute("corretor", corretor);
            return "paginaPrincipal"; // Página principal após login
        } else {
            model.addAttribute("erro", "Email ou senha inválidos.");
            return "login"; // Página de login com erro
        }
    }
}
