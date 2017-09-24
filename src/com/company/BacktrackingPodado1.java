package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BacktrackingPodado1 implements Backtracking {
    private Integer i;
    private ArrayList<Agente> agentes;
    private AnswerValidityChecker answerChecker;

    public BacktrackingPodado1(Integer i, ArrayList<Agente> agentes) {
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
            return confiables.size();
        }

        Set<Integer> confiablesConIndice = new HashSet<Integer>(confiables);
        confiablesConIndice.add(indice);

        Set<Integer> noConfiablesConIndice = new HashSet<Integer>(noConfiables);
        noConfiablesConIndice.add(indice);

        indice++;

        Integer leftRecursionPath = 0;
        Integer rightRecursionPath = 0;

        if (answerChecker.esValido(confiablesConIndice, noConfiables) && answerChecker.esConsistente(confiablesConIndice)) {
            leftRecursionPath = recursion(confiablesConIndice, noConfiables, indice);
        }
        if (answerChecker.esValido(confiables, noConfiablesConIndice) && answerChecker.esConsistente(confiables)) {
            rightRecursionPath = recursion(confiables, noConfiablesConIndice, indice);
        }

        return Math.max(leftRecursionPath, rightRecursionPath);
    }

}
