package com.seuProjeto.repository;

import com.seuProjeto.model.Corretor;
import com.seuProjeto.model.Imovel;
import com.seuProjeto.model.Casa;
import com.seuProjeto.model.Apartamento;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ImovelRepository {

    private static final String ARQUIVO_IMOVEIS = "imoveis.txt"; // Arquivo onde os imóveis são salvos

    // Método para buscar todos os imóveis
    public List<Imovel> buscarTodosImoveis() {
        List<Imovel> imoveis = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO_IMOVEIS))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");

                if (dados.length < 4) {
                    continue; // Pula linhas inválidas
                }

                String tipo = dados[0];         // Tipo do imóvel (Casa ou Apartamento)
                String descricao = dados[1];    // Descrição do imóvel
                String corretorEmail = dados[2]; // Email do corretor

                Corretor corretor = new Corretor(corretorEmail, "senhaExemplo", "Nome Corretor");

                if ("Casa".equals(tipo)) {
                    boolean possuiQuintal = Boolean.parseBoolean(dados[3]); // Campo adicional para Casa
                    imoveis.add(new Casa(descricao, corretor, possuiQuintal));
                } else if ("Apartamento".equals(tipo)) {
                    int andar = Integer.parseInt(dados[3]); // Campo adicional para Apartamento
                    imoveis.add(new Apartamento(descricao, corretor, andar));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imoveis;
    }

    // Método para salvar o imóvel no arquivo
    public void salvar(Imovel imovel) {
        // Verifica se o arquivo existe, caso contrário, cria
        try {
            File arquivo = new File(ARQUIVO_IMOVEIS);
            if (!arquivo.exists()) {
                arquivo.createNewFile();  // Cria o arquivo se ele não existir
            }

            FileWriter writer = new FileWriter(ARQUIVO_IMOVEIS, true); // 'true' para adicionar no final do arquivo
            String linha = imovel.getTipo() + "," + imovel.getDescricao() + "," + imovel.getCorretor().getEmail();
            if (imovel instanceof Casa) {
                linha += "," + ((Casa) imovel).isPossuiQuintal();
            } else if (imovel instanceof Apartamento) {
                linha += "," + ((Apartamento) imovel).getAndar();
            }
            linha += "\n";

            System.out.println("Salvando no arquivo: " + linha); // Log para depuração
            writer.write(linha); // Escreve no arquivo
            writer.close(); // Fecha o FileWriter após escrever
        } catch (IOException e) {
            e.printStackTrace();  // Log para depuração
        }
    }
}
