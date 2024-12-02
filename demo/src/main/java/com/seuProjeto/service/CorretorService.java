package com.seuProjeto.service;

import com.seuProjeto.repository.CorretorRepository;
import com.seuProjeto.model.Corretor;

public class CorretorService {
    private CorretorRepository corretorRepository;

    public CorretorService() {
        this.corretorRepository = new CorretorRepository();
    }

    public Corretor buscarCorretorPorEmailESenha(String email, String senha) {
        return corretorRepository.buscarCorretorPorEmailESenha(email, senha);
    }

    // Outros métodos de serviço
}
