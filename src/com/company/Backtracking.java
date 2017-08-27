package com.company;

import java.util.ArrayList;
import java.util.Set;

public class Backtracking {
    private Integer i;
    private Integer a;
    private ArrayList<Agente> agentes;

    public Backtracking(Integer i, Integer a, ArrayList<Agente> agentes){
        this.i = i;
        this.a = a;
        this.agentes = agentes;
    }

    /**
     * Una poda tiene que ser de optimización: eliminar una subrama porque sabemos que las soluciones que contiene son
     * validas pero no son optimas.
     * 
     */

    private Integer recursion(Set<Agente> confiables, Set<Agente> noConfiables, Integer indice){
        if (this.i - indice <= 0) {
            return evaluarConjunto(confiables, noConfiables);
        }

        Set<Agente> confiablesConIndice = confiables;
        confiablesConIndice.add(this.agentes.get(indice));

        Set<Agente> noConfiablesConIndice = noConfiables;
        noConfiablesConIndice.add(this.agentes.get(indice));

        indice++;

        return Math.max(recursion(confiablesConIndice, noConfiables, indice), recursion(confiables, noConfiablesConIndice, indice));
    }

    private Integer evaluarConjunto(Set<Agente> confiables, Set<Agente> noConfiables){
        if (esValido(confiables, noConfiables)){
            return confiables.size();
        } else {
            return 0;
        }
    }

    private Boolean esValido(Set<Agente> confiables, Set<Agente> noConfiables){
        if (confiables.size() == 0) {
            return true;
        }
        for (Agente confiable : confiables){
            if (confiable.confíaEnAgentes(noConfiables) || confiable.desconfíaEnAgentes(confiables)){
                return false;
            }
        }
        return true;
    }


}
