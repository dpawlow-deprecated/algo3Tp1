package com.company;

import java.util.*;

public class Tests {

    public void main() {
        System.out.println("Corrida de las " + System.currentTimeMillis());
        agentesCrecientesEncuestasAleatorias();
        agentesCrecientesEncuestasPositivas();
        agentesCrecientesEncuestasRestringidas();
    }

    private void agentesCrecientesEncuestasAleatorias() {
        Random r = new Random();

        for (int repeticiones = 0; repeticiones <= 100; repeticiones++) {
            for (int i = 1; i <= 400; i++) {

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

                calcularCaso(agentes, i, "encuestas aleatorias");
            }
        }
    }

    private void agentesCrecientesEncuestasPositivas(){
        Random r = new Random();

        for (int repeticiones = 0; repeticiones <= 100; repeticiones++) {
            for (int i = 1; i <= 100; i++) {
                long inicio;
                long promedio;
                long fin;

                ArrayList<Agente> agentes = new ArrayList<>();
                for (int k = 1; k <= i; k++) {
                    Set<Integer> confiables = new HashSet<>();
                    Set<Integer> noConfiables = new HashSet<>();

                    Integer maxConfiables = r.nextInt(i) + 1;

                    for (int j = 1; j <= maxConfiables; j++) {
                        confiables.add(r.nextInt(i) + 1);
                    }

                    Agente agente = new Agente(k, confiables, noConfiables);
                    agentes.add(agente);
                }

                calcularCaso(agentes, i, "encuestas positivas");
            }
        }
    }

    private void agentesCrecientesEncuestasRestringidas(){
        Random r = new Random();

        for (int repeticiones = 0; repeticiones <= 40; repeticiones++) {
            for (int i = 1; i <= 40; i++) {
                long inicio;
                long promedio;
                long fin;

                ArrayList<Agente> agentes = new ArrayList<>();
                for (int k = 1; k <= i; k++) {
                    Set<Integer> confiables = new HashSet<>();
                    Set<Integer> noConfiables = new HashSet<>();

                    Integer maxConfiables = r.nextInt((int)Math.ceil(i/50)+1) + 1;
                    Integer maxNoConfiables = r.nextInt((int)Math.ceil(i/50)+1) + 1;

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

                calcularCaso(agentes, i, "encuestas restringidas");
            }
        }
    }

    private void calcularCaso(ArrayList<Agente> agentes, int i, String frase){
        long promedio = 0;
        ArrayList<Long> tiempos = new ArrayList<Long>();

        BacktrackingPuro bt = new BacktrackingPuro(i, agentes);
        BacktrackingPodado1 btp1 = new BacktrackingPodado1(i, agentes);
        BacktrackingPodado2 btp2 = new BacktrackingPodado2(i, agentes);

        tiempos = repetirExperimentos(bt);
        promedio = promedioAlfaPodado(tiempos);

        System.out.println("Bactracking " + frase + ";" + i + ";" + promedio + ";");

        tiempos = repetirExperimentos(btp1);
        promedio = promedioAlfaPodado(tiempos);

        System.out.println("BactrackingPodado1 " + frase + ";" + i + ";" + promedio + ";");

        tiempos = repetirExperimentos(btp2);
        promedio = promedioAlfaPodado(tiempos);

        System.out.println("BactrackingPodado2 " + frase + ";" + i + ";" + promedio + ";");
    }

    private ArrayList<Long> repetirExperimentos(Backtracking bt){
        long inicio = 0;
        long fin = 0;
        Integer maxConfiables = 0;
        ArrayList<Long> tiempos = new ArrayList<Long>();

        for (int k = 1; k <= 30; k++) {
            inicio = System.nanoTime();
            maxConfiables = bt.calcularMaxConfiables();
            fin = System.nanoTime();
            tiempos.add(fin - inicio);
        }
        return tiempos;
    }

    private Long promedioAlfaPodado(ArrayList<Long> tiempos){
        Collections.sort(tiempos);
        long promedio = 0;
        int count = 0;

        for (int k = 5; k <= 25; k++) {
            promedio += tiempos.get(k);
            count++;
        }
        return promedio/count;
    }

}
