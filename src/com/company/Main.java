package com.company;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Integer i = 4;
        Integer a = 5;
        ArrayList<Agente> agentes = null;

        for (int index=1; index <= i; index++){
            agentes.add(new Agente(index));
        }

        agentes.get(1).agregarConfiable(agentes.get(2));
        agentes.get(1).agregarDesconfiable(agentes.get(4));

        agentes.get(2).agregarDesconfiable(agentes.get(3));

        agentes.get(3).agregarConfiable(agentes.get(1));
        agentes.get(3).agregarConfiable(agentes.get(4));
    }
}
