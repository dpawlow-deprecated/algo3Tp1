package com.company;

import java.util.Set;


public class Agente {
    private final int id;
    private Set<Agente> confiables;
    private Set<Agente> noConfiables;

    public Agente(int id){
        this.id = id;
    }

    public Boolean confíaEnAgentes(Set<Agente> agentes){
        agentes.retainAll(this.confiables);
        return !agentes.isEmpty();
    }

    public Boolean desconfíaEnAgentes(Set<Agente> agentes){
        agentes.retainAll(this.noConfiables);
        return !agentes.isEmpty();
    }

    public void agregarConfiable(Agente agente){
        this.confiables.add(agente);
    }

    public void agregarDesconfiable(Agente agente){
        this.noConfiables.add(agente);
    }

    public int getId(){
        return this.id;
    }

    @Override public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Agente) {
            Agente that = (Agente) other;
            result = this.getId() == that.getId();
        }
        return result;
    }

    @Override public int hashCode() {
        return getId();
    }
}
