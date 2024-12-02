package com.seuProjeto.controller;

import com.seuProjeto.model.Apartamento;
import com.seuProjeto.model.Casa;
import com.seuProjeto.model.Corretor;
import com.seuProjeto.model.Imovel;
import com.seuProjeto.repository.ImovelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ImovelController {

    @Autowired
    private ImovelRepository imovelRepository;

    // Rota para exibir os imóveis
    @GetMapping("/imoveis")
    public String listarImoveis(Model model) {
        model.addAttribute("imoveis", imovelRepository.buscarTodosImoveis());
        return "imoveis";  // Nome do arquivo HTML do template que lista os imóveis
    }

    // Rota para exibir o formulário de cadastro
    @GetMapping("/imoveis/cadastrar")
    public String exibirFormularioCadastro() {
        return "cadastrar"; // Nome do arquivo HTML do formulário de cadastro
    }

    // Rota para processar o cadastro do imóvel
    @PostMapping("/imoveis/cadastrar")
    public String cadastrarImovel(@RequestParam String descricao, @RequestParam String tipo, @RequestParam String corretorEmail,
                                  @RequestParam(required = false) String quintal, @RequestParam(required = false) String andar) {

        if (corretorEmail == null || corretorEmail.isEmpty()) {
            return "redirect:/imoveis/cadastrar?error=emailInvalido";  // Redireciona com mensagem de erro
        }

        Corretor corretor = new Corretor(corretorEmail, "senhaExemplo", "Nome Corretor");

        Imovel imovel = null;

        if ("Casa".equals(tipo)) {
            boolean possuiQuintal = (quintal != null && !quintal.isEmpty()) ? Boolean.parseBoolean(quintal) : false;
            imovel = new Casa(descricao, corretor, possuiQuintal);
        } else if ("Apartamento".equals(tipo)) {
            int andarNumero = (andar != null && !andar.isEmpty()) ? Integer.parseInt(andar) : 0;
            imovel = new Apartamento(descricao, corretor, andarNumero);
        }

        if (imovel != null) {
            imovelRepository.salvar(imovel);
        } else {
            return "redirect:/imoveis/cadastrar?error=tipoInvalido";
        }

        return "redirect:/imoveis";  // Redireciona para a lista de imóveis
    }
}
