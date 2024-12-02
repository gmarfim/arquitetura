package com.seuProjeto.controller;

import com.seuProjeto.model.Corretor;
import com.seuProjeto.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    private final CorretorRepository corretorRepository;

    @Autowired
    public AuthController(CorretorRepository corretorRepository) {
        this.corretorRepository = corretorRepository;
    }

    // Exibe a página de login
    @GetMapping("/login")
    public String loginPage() {
        return "login";  // Página de login
    }

    // Trata o login
    @PostMapping("/login")
    public String login(String email, String senha, Model model) {
        // Usando o método correto para buscar o corretor
        Corretor corretor = corretorRepository.buscarCorretorPorEmailESenha(email, senha);

        if (corretor != null) {
            // Login bem-sucedido, adiciona o corretor ao modelo
            model.addAttribute("corretor", corretor);
            return "redirect:/imoveis"; // Redireciona para a página de imóveis
        } else {
            // Login falhou, adiciona mensagem de erro
            model.addAttribute("erro", "Credenciais inválidas");
            return "login"; // Retorna à página de login com erro
        }
    }
}
