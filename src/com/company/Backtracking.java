package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Backtracking {
    private Integer i;
    private ArrayList<Agente> agentes;
    private AnswerValidityChecker answerChecker;

    public Backtracking(Integer i, ArrayList<Agente> agentes) {
        this.i = i;
        this.agentes = agentes;
        this.answerChecker = new AnswerValidityChecker(agentes);
    }

    public Integer calcularMaxConfiables() {
        Set<Integer> confiables = new HashSet<Integer>();
        Set<Integer> noConfiables = new HashSet<Integer>();
        return recursion(confiables, noConfiables, 0);
    }

    private Integer recursion(Set<Integer> confiables, Set<Integer> noConfiables, Integer indice) {
        if (this.i - indice <= 0) {
            return answerChecker.evaluarConjunto(confiables, noConfiables);
        }

        Set<Integer> confiablesConIndice = new HashSet<Integer>(confiables);
        confiablesConIndice.add(indice);

        Set<Integer> noConfiablesConIndice = new HashSet<Integer>(noConfiables);
        noConfiablesConIndice.add(indice);

        indice++;

        return Math.max(recursion(confiablesConIndice, noConfiables, indice), recursion(confiables, noConfiablesConIndice, indice));
    }

}
