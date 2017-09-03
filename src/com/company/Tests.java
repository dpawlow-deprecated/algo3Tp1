package com.company;

import java.util.*;

public class Tests {

    public void main() {
        Random r = new Random();

        System.out.println("Agentes crecientes, encuestas aleatorias");
        for (int repeticiones = 0; repeticiones <= 100; repeticiones++) {
            for (int i = 1; i <= 400; i++) {
                long inicio;
                long promedio;
                long fin;

                ArrayList<Agente> agentes = new ArrayList<>();
                for (int k = 1; k <= i; k++) {
                    Set<Integer> confiables = new HashSet<>();
                    Set<Integer> noConfiables = new HashSet<>();

                    Integer maxConfiables = r.nextInt(i) + 1;
                    Integer maxNoConfiables = r.nextInt(i) + 1;

                    for (int j = 1; j <= maxConfiables; j++) {
                        confiables.add(r.nextInt(i) + 1);
                    }
                    for (int j = 1; j <= maxNoConfiables; j++) {
                        noConfiables.add(r.nextInt(i) + 1);
                    }
                    noConfiables.remove(confiables);
                    Agente agente = new Agente(k, confiables, noConfiables);
                    agentes.add(agente);
                }

                Backtracking bt = new Backtracking(i, agentes);
                BacktrackingPodado1 btp1 = new BacktrackingPodado1(i, agentes);
                BacktrackingPodado2 btp2 = new BacktrackingPodado2(i, agentes);

                inicio = System.nanoTime();
                Integer btMax = bt.calcularMaxConfiables();
                fin = System.nanoTime();

                System.out.println("Bactracking encuestas aleatorias;" + i + ";" + btMax + ";" + (fin - inicio) + ";");

                inicio = System.nanoTime();
                Integer btMaxP1 = btp1.calcularMaxConfiables();
                fin = System.nanoTime();

                System.out.println("BactrackingPodado1 encuestas aleatorias;" + i + ";" + btMaxP1 + ";" + (fin - inicio) + ";");

                inicio = System.nanoTime();
                Integer btMaxP2 = btp2.calcularMaxConfiables();
                fin = System.nanoTime();

                System.out.println("BactrackingPodado2 encuestas aleatorias;" + i + ";" + btMaxP2 + ";" + (fin - inicio) + ";");

            }

        }


    }





}
