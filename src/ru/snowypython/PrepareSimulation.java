package ru.snowypython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrepareSimulation extends Actions {
    public static int countPredators;
    public static int countHerbivores;

    public static void prepareSimulation() {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.println("Введите кол-во хищников");
            countPredators = Integer.parseInt(consoleReader.readLine());
            System.out.println("Введите кол-во травоядных");
            countHerbivores = Integer.parseInt(consoleReader.readLine());
        } catch (IOException e) {
            System.out.println("Некоректные данные");
        }
    }
}
