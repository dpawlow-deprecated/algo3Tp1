package com.company;

import java.util.ArrayList;
import java.util.Set;

public class AnswerValidityChecker {

    private ArrayList<Agente> agentes;

    public AnswerValidityChecker(ArrayList<Agente> agentes) {
        this.agentes = agentes;
    }

    public Integer evaluarConjunto(Set<Integer> confiables, Set<Integer> noConfiables) {
        if (esValido(confiables, noConfiables)) {
            return confiables.size();
        } else {
            return 0;
        }
    }

    public Boolean esValido(Set<Integer> confiables, Set<Integer> noConfiables) {
        if (confiables.size() == 0) {
            return true;
        }
        for (Integer confiable : confiables) {
            if (this.agentes.get(confiable).confiaEnAgentes(noConfiables) || this.agentes.get(confiable).desconfiaEnAgentes(confiables)) {
                return false;
            }
        }
        return true;
    }

    public Boolean esConsistente(Set<Integer> confiables) {
        if (confiables.size() == 0) {
            return true;
        }
        for (Integer agente1 : confiables) {
            for (Integer agente2 : confiables) {
                if (agente1 != agente2 && (this.agentes.get(agente1).confiaEnAgentes(this.agentes.get(agente2).getNoConfiables()) ||
                        this.agentes.get(agente1).desconfiaEnAgentes(this.agentes.get(agente2).getConfiables()))) {
                    return false;
                }
            }
        }
        return true;
    }
}
