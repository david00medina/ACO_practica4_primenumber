package aco_practica4;

public class AlgorithmTester {
    
    public static double successRatio(PrimeNumberAnalizer pna, int n, boolean isPrime) {
        double success = .0;
        for (int i = 0; i < n; i++) {
            if(isPrime && pna.isPrime() == 0) {
                success++;
            } else if(!isPrime && (pna.isPrime() == 1 || pna.isPrime() == 2)) {
                success++;
            }
        }
        if(isPrime)
            System.out.print("Probabilidad de que sea primo : ");
        else
            System.out.print("Probabilidad de que sea compuesto : ");

        System.out.println(success/n);
        return success/n;
    }
}
