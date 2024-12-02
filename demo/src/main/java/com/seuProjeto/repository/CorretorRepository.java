package com.seuProjeto.repository;

import com.seuProjeto.model.Corretor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CorretorRepository {

    private List<Corretor> corretores = new ArrayList<>();

    public CorretorRepository() {
        // Inicializando com alguns dados
        corretores.add(new Corretor("exemplo@dominio.com", "senha123", "teste"));
    }

    // Método para buscar o corretor por e-mail e senha
    public Corretor buscarCorretorPorEmailESenha(String email, String senha) {
        for (Corretor corretor : corretores) {
            if (corretor.getEmail().equals(email) && corretor.getSenha().equals(senha)) {
                return corretor;
            }
        }
        return null; // Retorna null se não encontrar o corretor
    }

    // Método para adicionar um novo corretor
    public void adicionarCorretor(Corretor corretor) {
        corretores.add(corretor);
    }

    // Método para obter todos os corretores (opcional, se precisar)
    public List<Corretor> getCorretores() {
        return corretores;
    }
}
