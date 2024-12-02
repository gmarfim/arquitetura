package com.seuProjeto.model;

public class Casa extends Imovel {
    private boolean possuiQuintal;

    public Casa(String descricao, Corretor corretor, boolean possuiQuintal) {
        super(descricao, corretor);
        this.possuiQuintal = possuiQuintal;
    }

    public boolean isPossuiQuintal() {
        return possuiQuintal;
    }

    public void setPossuiQuintal(boolean possuiQuintal) {
        this.possuiQuintal = possuiQuintal;
    }

    @Override
    public String getTipo() {
        return "Casa";
    }
}
