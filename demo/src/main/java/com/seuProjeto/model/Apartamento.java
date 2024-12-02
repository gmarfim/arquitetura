package com.seuProjeto.model;

public class Apartamento extends Imovel {
    private int andar;

    public Apartamento(String descricao, Corretor corretor, int andar) {
        super(descricao, corretor);
        this.andar = andar;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    @Override
    public String getTipo() {
        return "Apartamento";
    }
}
