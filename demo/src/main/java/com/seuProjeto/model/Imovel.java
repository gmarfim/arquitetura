package com.seuProjeto.model;

public abstract class Imovel {
    private String descricao;
    private Corretor corretor;

    public Imovel(String descricao, Corretor corretor) {
        this.descricao = descricao;
        this.corretor = corretor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Corretor getCorretor() {
        return corretor;
    }

    public void setCorretor(Corretor corretor) {
        this.corretor = corretor;
    }

    public abstract String getTipo();
}
