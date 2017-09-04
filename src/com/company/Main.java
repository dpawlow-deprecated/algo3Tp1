package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Integer[] lista = null;
        Scanner in = new Scanner(System.in);

        int i = 0;
        int a = 0;
        int cero = 0;
        while (in.hasNextInt()) {

            i = in.nextInt();
            a = in.nextInt();

            if (a == 0 && i == 0){
                break;
            }

            ArrayList<Agente> agentes = new ArrayList<>();
            for (int k = 0; k < i; k++) {
                Agente agente = new Agente(k);
                agentes.add(agente);
            }

            for (int k = 0; k < a; k++) {
                int idAgente = in.nextInt();
                int encuesta = in.nextInt();

                System.out.println("id agente: " + idAgente + ", encuesta: " + encuesta);

                if (encuesta < 0) {
                    agentes.get(idAgente-1).agregarDesconfiable(-encuesta);
                } else {
                    agentes.get(idAgente-1).agregarConfiable(encuesta);
                }
            }

            Backtracking bt = new Backtracking(i, agentes);
            BacktrackingPodado1 btp1 = new BacktrackingPodado1(i, agentes);
            BacktrackingPodado2 btp2 = new BacktrackingPodado2(i, agentes);

            Integer maxConfiablesBT = bt.calcularMaxConfiables();
            Integer maxConfiablesBTP1 = btp1.calcularMaxConfiables();
            Integer maxConfiablesBTP2 = btp2.calcularMaxConfiables();

            if ( maxConfiablesBT.equals(maxConfiablesBTP1) && maxConfiablesBT.equals(maxConfiablesBTP2)){
                System.out.println(maxConfiablesBT);
            } else {
                System.out.println("Error! Las respuestas no coinciden: " + maxConfiablesBT + " " + maxConfiablesBTP1 + " " + maxConfiablesBTP2);
            }
        }
        in.close();

    }
}
