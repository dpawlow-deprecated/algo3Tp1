package com.company;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by dpawlow on 8/27/17.
 */
public class AnswerValidityChecker {

    private ArrayList<Agente> agentes;

    public AnswerValidityChecker(ArrayList<Agente> agentes){
        this.agentes = agentes;
    }

    public Integer evaluarConjunto(Set<Integer> confiables, Set<Integer> noConfiables){
        if (esValido(confiables, noConfiables)){
            return confiables.size();
        } else {
            return 0;
        }
    }

    public Boolean esValido(Set<Integer> confiables, Set<Integer> noConfiables){
        if (confiables.size() == 0) {
            return true;
        }
        for (Integer confiable : confiables){
            if (this.agentes.get(confiable).confiaEnAgentes(noConfiables) || this.agentes.get(confiable).desconfiaEnAgentes(confiables)){
                return false;
            }
        }
        return true;
    }


}
