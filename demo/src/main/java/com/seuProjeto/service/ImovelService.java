package com.seuProjeto.service;

import com.seuProjeto.model.Imovel;
import com.seuProjeto.model.Casa;
import com.seuProjeto.model.Apartamento;
import com.seuProjeto.model.Corretor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImovelService {

    // Método para buscar todos os imóveis cadastrados
    public List<Imovel> buscarTodosImoveis() {
        List<Imovel> imoveis = new ArrayList<>();

        // Exemplo de corretor para associar aos imóveis
        Corretor corretor = new Corretor("corretor@exemplo.com", "123456", "Corretor Exemplo");

        // Adicionando alguns imóveis à lista
        imoveis.add(new Casa("Casa de 3 quartos com quintal", corretor, true));
        imoveis.add(new Apartamento("Apartamento de 2 quartos", corretor, 5));

        return imoveis;
    }

    // Método para cadastrar imóvel (pode ser estendido)
    public void cadastrarImovel(Imovel imovel) {
        // Lógica de cadastro (exemplo)
        System.out.println("Imóvel cadastrado: " + imovel.getDescricao());
    }
}
