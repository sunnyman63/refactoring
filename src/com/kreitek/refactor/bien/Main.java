package com.kreitek.refactor.bien;

import com.kreitek.refactor.bien.domain.*;

import java.util.*;

class Main
{
    public static void main(String args[])
    {
        System.out.println("=====================");
        System.out.println("Vamos a refactorizar!");
        System.out.println("=====================");

        List<Documento> docs = new ArrayList<Documento>();
        docs.add(new DNI("11111111H", null));
        docs.add(new DNI("24324356A", null));
        docs.add(new NIE("X0932707B", null));
        docs.add(new NIE("Z2691139Z", null));
        docs.add(new CIF("W9696294I", null));
        docs.add(new CIF("W9696294A", null));

        for (Documento doc:docs) {
            System.out.println( doc.getTipo() + " " + doc.getNumDoc() + " es: " + doc.isValid());
        }
    }
}