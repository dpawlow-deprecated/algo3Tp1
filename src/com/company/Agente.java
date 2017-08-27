package com.company;

import java.util.HashSet;
import java.util.Set;


public class Agente {
    private final Integer id;
    private Set<Integer> confiables;
    private Set<Integer> noConfiables;

    public Agente(Integer id) {
        this.id = id;
        this.confiables = new HashSet<Integer>();
        this.noConfiables = new HashSet<Integer>();
    }

    public Boolean confiaEnAgentes(Set<Integer> agentes) {
        Set<Integer> agentesCopy = new HashSet<>(agentes);
        agentesCopy.retainAll(this.confiables);
        return !agentesCopy.isEmpty();
    }

    public Boolean desconfiaEnAgentes(Set<Integer> agentes) {
        Set<Integer> agentesCopy = new HashSet<>(agentes);
        agentesCopy.retainAll(this.noConfiables);
        return !agentesCopy.isEmpty();
    }

    public void agregarConfiable(Integer agente) {
        this.confiables.add(agente);
    }

    public void agregarDesconfiable(Integer agente) {
        this.noConfiables.add(agente);
    }

    public int getId() {
        return this.id;
    }

    @Override
    public boolean equals(Object other) {
        boolean result = false;
        if (other instanceof Agente) {
            Agente that = (Agente) other;
            result = this.getId() == that.getId();
        }
        return result;
    }

    @Override
    public int hashCode() {
        return getId();
    }
}
