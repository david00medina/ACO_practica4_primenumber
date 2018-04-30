package aco_practica4;

public class Main {

    public static void main(String[] args) {
        int n = 3;
        int m = 4;
        PrimeNumberAnalizer pna = new PrimeNumberAnalizer(3,4);
        if(pna.exec())
            System.out.println("[+] Resultado : " + n + " es un número primo.");
        else
            System.out.println("[+] Resultado : " + n + " no es un número primo.");
    }
    
}
