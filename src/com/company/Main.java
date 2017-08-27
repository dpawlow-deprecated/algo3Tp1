package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Integer i = 4;
        Integer a = 5;
        ArrayList<Agente> agentes = new ArrayList<>();

        for (int index = 0; index < i; index++) {
            agentes.add(new Agente(index));
        }

        agentes.get(1 - 1).agregarConfiable(2 - 1);
        agentes.get(1 - 1).agregarDesconfiable(4 - 1);

        agentes.get(2 - 1).agregarDesconfiable(3 - 1);

        agentes.get(3 - 1).agregarConfiable(1 - 1);
        agentes.get(3 - 1).agregarConfiable(4 - 1);

        Backtracking bt = new Backtracking(i, agentes);
        System.out.println("Max nro confiables bactracking: " + bt.calcularMaxConfiables());

        BacktrackingPodado1 btp1 = new BacktrackingPodado1(i, agentes);
        System.out.println("Max nro confiables bactracking podado 1: " + btp1.calcularMaxConfiables());
    }
}
