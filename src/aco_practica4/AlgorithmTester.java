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
        
        return success/n;
    }
}
