package aco_practica4;

public class Main {

    public static void main(String[] args) {
        int n = 9975;
        int m = 1000;
        PrimeNumberAnalizer pna = new PrimeNumberAnalizer(n,m);
        switch(pna.isPrime()) {
            case 0:
                System.out.println("[+] Resultado : " + n + " es un número primo.");
                break;
            case 1:
                System.out.println("[+] Resultado : " + n + " es un número compuesto.");
                break;
            case 2:
                System.out.println("[!] Error : " + n + " no es un número impar.");
                break;
            default:
                break;
        }
        /*if(pna.isPrime())
            System.out.println("[+] Resultado : " + n + " es un número primo.");
        else
            System.out.println("[+] Resultado : " + n + " no es un número primo.");*/
    }
    
}
