package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Drug> drugList = new ArrayList<>();
        initializeList(drugList);

        System.out.println("Search by: 1 - Type; 2 - Price");
        Scanner scanner = new Scanner(System.in);
        String search = scanner.next();
        switch (search) {
            case "1":
                System.out.println("1 - Antibiotics; 2 - Anti-inflammatory; 3 - Antipyretic");
                String choise = scanner.next();
                SearchManager searchManager = new SearchManager(drugList);

                switch (choise) {
                    case "1":
                        drugList = searchManager.findByType("Antibiotics");
                        break;
                    case "2":
                        drugList = searchManager.findByType("Anti-inflammatory");
                        break;
                    case "3":
                        drugList = searchManager.findByType("Antipyretic");
                        break;
                    default:
                        return;
                }

                SortManager sortManager = new SortManager(drugList);

                List<Drug> tempResult = sortManager.sortByNumber(true);
                for (Drug r : tempResult) {
                    System.out.println(r);
                }
                System.out.println();
                tempResult = sortManager.sortByPrice(false);
                for (Drug r : tempResult) {
                    System.out.println(r);
                }
                System.out.println();
                tempResult = sortManager.sortByType(false);
                for (Drug r : tempResult) {
                    System.out.println(r);
                }
                System.out.println();
                tempResult = sortManager.sortByName(false);
                for (Drug r : tempResult) {
                    System.out.println(r);
                }
                scanner.close();
                break;
            case "2":
                System.out.println("Enter min price:");
                Float min = Float.valueOf(scanner.next());
                System.out.println("Enter max price:");
                Float max = Float.valueOf(scanner.next());

                SearchManager searchManager2 = new SearchManager(drugList);

                drugList = searchManager2.findByPrice(min,max);
                for (Drug r : drugList) {
                    System.out.println(r);
                }

                System.out.println();
                SortManager sortManager2 = new SortManager(drugList);
                tempResult = sortManager2.sortByType(false);
                for (Drug r : tempResult) {
                    System.out.println(r);
                }
                break;
            default:
                return;
        }
    }
    private static void initializeList (List < Drug > drug) {
        for (int i = 0; i < 3; i++) {
            drug.add(new Infuzolid(202.8f));
            drug.add(new Sargin(90.25f));
            drug.add(new Analgin(40.00f));
        }

        for (int i = 0; i < 2; i++) {
            drug.add(new Voltaren(267.80f));
            drug.add(new Augmentin(157.60f));
            drug.add(new Paracetamol(28.90f));
        }

        drug.add(new Fedin(67.50f));
        drug.add(new Gofen(49.50f));
    }
}
