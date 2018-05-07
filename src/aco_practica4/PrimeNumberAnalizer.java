package aco_practica4;

import java.math.BigInteger;
import java.util.ArrayList;
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
        
        if(!isOdd(n) && n != 2) {
            System.out.println("FAIL!");
            return 2;
        }
        
        System.out.println("OK!");
        
        if(n == 1 || n == 2) return 0;
        
        int[] selected = generateRandomIntegers();
        int[] k = estimateInteger();
        for (int item : selected) 
            if(!fermatLittleTheorem(item) || !secondTest(item, k)) return 1;
        
        return 0;
    }

    private boolean isOdd(int n) {
        if(n % 2 == 1) return true;
        
        return false;
    }

    private int[] generateRandomIntegers() {
        Random ran = new Random();
        Set<Integer> set = new HashSet<Integer>();
        int N = n-2;
        for (int i = 0; i < m; i++)
            set.add(ran.nextInt(N)+2);
        
        int[] selected = new int[set.size()];
        int i = 0;
        for (Integer num : set) {
            selected[i] = num.intValue();
            i++;
        }
        return selected;
    }

    private boolean fermatLittleTheorem(int item) {
        BigInteger bg = new BigInteger(String.valueOf(item));
        bg = bg.modPow(new BigInteger(String.valueOf(n-1)), new BigInteger(String.valueOf(n)));
        
        if(bg.intValue() != 1)
            return false;
        return true;
    }

    private boolean secondTest(int item, int[] k) {
        int cont = 0;
        for (int exp : k) {
            BigInteger result = BigInteger.valueOf(item).pow(exp).subtract(BigInteger.ONE);
            BigInteger gcd = greatestCommonDivisor(result);
            if(gcd.compareTo(BigInteger.ONE) == 1 && gcd.compareTo(BigInteger.valueOf(n)) == -1) cont++;
        }
        if(cont == k.length) return false;
        return true;
    }
    
    private int[] estimateInteger() {
        int j = 1;
        ArrayList<Integer> k = new ArrayList<>();
        while((n-1) % (int)Math.pow(2, j) == 0) {
            k.add((n-1) / (int)Math.pow(2, j));
            j++;
        }
        
        int[] out = new int[k.size()];
        for (int i = 0; i < k.size(); i++) {
            out[i] = k.get(i);
            
        }
        return out;
    }

    private BigInteger greatestCommonDivisor(BigInteger num) {
        return num.gcd(BigInteger.valueOf(n));
    }
}
