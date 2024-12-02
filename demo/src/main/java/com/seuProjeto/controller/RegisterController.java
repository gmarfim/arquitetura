package com.seuProjeto.controller;

import com.seuProjeto.model.Corretor;
import com.seuProjeto.repository.CorretorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private final CorretorRepository corretorRepository;

    @Autowired
    public RegisterController(CorretorRepository corretorRepository) {
        this.corretorRepository = corretorRepository;
    }

    // Exibe a página de cadastro (GET)
    @GetMapping
    public String registerPage() {
        return "register"; // Nome da página de registro (register.html)
    }

    // Trata o envio do formulário de registro (POST)
    @PostMapping
    public String registerCorretor(@RequestParam String email, @RequestParam String senha, @RequestParam String nome, Model model) {
        // Criando o corretor com os 3 parâmetros
        Corretor novoCorretor = new Corretor(email, senha, nome);

        // Adicionando o novo corretor no repositório
        corretorRepository.adicionarCorretor(novoCorretor);

        // Adicionando uma mensagem de sucesso ao modelo
        model.addAttribute("mensagem", "Cadastro realizado com sucesso!");

        // Redireciona para a página de login
        return "login";  // Ou outra página, se você preferir
    }
}
