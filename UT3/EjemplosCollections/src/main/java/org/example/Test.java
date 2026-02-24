package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {
    public static void main() {
        Coche c1 =new Coche("1234FRT","Peugeot","308");
        Coche c2 = new Coche("4358MRT","Audi","A3");
        Coche c3=new Coche("1234FRT","Peugeot","308");
        Coche c4=new Coche("7896DER","Peugeot","308");

        //List<Coche> misCoches = new ArrayList<>();
        Set<Coche> misCoches = new HashSet<>();
        misCoches.add(c1);
        misCoches.add(c2);
        misCoches.add(c3);


       // System.out.println(misCoches.get(1));

        if(misCoches.contains(c4)){
            System.out.println("El coche existe");
        }else{
            System.out.println("El COCHE NO EXISTE");
        }

        System.out.println(misCoches);

        misCoches.remove(c1);

        System.out.println(misCoches);

    }
}
