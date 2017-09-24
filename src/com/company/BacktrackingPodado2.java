package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class BacktrackingPodado2 implements Backtracking {
    private Integer i;
    private Integer maxConfiables;
    private ArrayList<Agente> agentes;
    private AnswerValidityChecker answerChecker;

    public BacktrackingPodado2(Integer i, ArrayList<Agente> agentes) {
        this.i = i;
        this.maxConfiables = 0;
        this.agentes = agentes;
        this.answerChecker = new AnswerValidityChecker(agentes);
    }

    private void setMaxConfiables(Integer n) {
        this.maxConfiables = Math.max(n, this.maxConfiables);
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
        if (this.i - noConfiables.size() <= this.maxConfiables) {
            return 0;
        }
        Set<Integer> confiablesConIndice = new HashSet<Integer>(confiables);
        Set<Integer> noConfiablesConIndice = new HashSet<Integer>(noConfiables);
        confiablesConIndice.add(indice);
        noConfiablesConIndice.add(indice);

        indice++;

        Integer leftRecursionPath = 0;
        Integer rightRecursionPath = 0;
        if (answerChecker.esValido(confiablesConIndice, noConfiables)) {
            leftRecursionPath = recursion(confiablesConIndice, noConfiables, indice);
        }
        if (answerChecker.esValido(confiables, noConfiablesConIndice)) {
            rightRecursionPath = recursion(confiables, noConfiablesConIndice, indice);
        }

        Integer maxSetSize = Math.max(leftRecursionPath, rightRecursionPath);
        this.setMaxConfiables(maxSetSize);
        return maxSetSize;
    }

}
