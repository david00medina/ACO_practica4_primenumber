package aco_practica4;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class PrimeNumberAnalizer {
    private int n;
    private int m;
    
    public PrimeNumberAnalizer(int n, int m) {
        this.n = n;
        this.m = m;
    }
    
    
    
    public int isPrime() {
        System.out.print("[+] PRUEBA : Número impar . . . ");
        
        if(!isOdd(n)) {
            System.out.println("FAIL!");
            return 2;
        }
        
        System.out.println("OK!");
        
        int[] selected = generateRandomIntegers();
        int k = estimateInteger();
        for (int item : selected) {
            if(!fermatLittleTheorem(item) || !secondTest(item, k))
                return 1;
        }
        
        return 0;
    }

    private boolean isOdd(int n) {
        if(n % 2 == 1)
            return true;
        
        return false;
    }

    private int[] generateRandomIntegers() {
        Random ran = new Random();
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < m; i++)
            set.add(ran.nextInt(n-1) + 1);
        
        int[] selected = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            selected[i] = num.intValue();
            i++;
        }
        return selected;
    }

    private boolean fermatLittleTheorem(int item) {
        if((int)Math.pow(item, n-1) % n != 1)
            return false;
        return true;
    }

    private boolean secondTest(int item, int k) {
        int gcd = greatestCommonDivisor((int)Math.pow(item, k)-1);
        if(1 < gcd && gcd < n)
            return false;
        
        return true;
    }
    
    // ¿Cuantas j hay que probar? ¿Es la primera que haga k entera? ¿Qué intervalo?
    private int estimateInteger() {
        int j = 1;
        while((n-1) % (int)Math.pow(2, j) != 0)
            j++;
        return (n-1) / (int)Math.pow(2, j);
    }

    private int greatestCommonDivisor(int power) {
        BigInteger a = new BigInteger(new Integer(power).toString());
        return new Integer(
                a.gcd(
                        new BigInteger(
                                new Integer(n).toString())).toString()).intValue();
    }
}
