package aco_practica4;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("||\t\tBUSCADOR NÚMEROS PRIMOS\t\t||");
        System.out.println("==================================================");
        System.out.print("Introduzca el número a comprobar (n) : ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.print("Introduzca el número de enteros de prueba (m) : ");
        int m = scan.nextInt();
        System.out.print("Introduzca el número de pruebas a ejecutar (Cálculo de % acierto) : ");
        int p = scan.nextInt();
        
        boolean isPrime = false;
        boolean correct = false;
        String selection = "";
        do {
            switch(selection) {
                case "s":
                case "S":
                    isPrime = true;
                    correct = true;
                    break;
                case "n":
                case "N":
                    isPrime = false;
                    correct = true;
                    break;
                default:
                    selection = scan.nextLine();
                    System.out.print("¿El número introducido es primo? (S/n) : ");
                    break;
            }
        } while (!correct);
        
        System.out.println();
        PrimeNumberAnalizer pna = new PrimeNumberAnalizer(n,m);
        
        System.out.println("==================================================");
        System.out.println("||\t\tESTADÍSTICA ALGORITMO\t\t||");
        System.out.println("==================================================");
        double ratio = AlgorithmTester.successRatio(pna, p, isPrime);
        
        System.out.println("==================================================");
        System.out.println("||\t\tRESULTADO ALGORITMO\t\t||");
        System.out.println("==================================================");
        switch(pna.isPrime()) {
            case 0:
                System.out.println("[+] Resultado : " + n + " es un número primo.");
                break;
            case 1:
                System.out.println("[+] Resultado : " + n + " es un número COMPUESTO.");
                break;
            case 2:
                System.out.println("[!] Error : " + n + " es un número PAR/COMPUESTO.");
                break;
            default:
                break;
        }
        
        if(isPrime)
            System.out.println("[+] Probabilidad de que sea primo : " + ratio*100 + "%");
        else
            System.out.println("[+] Probabilidad de que sea compuesto : " + ratio*100 + "%");

    }
    
}
