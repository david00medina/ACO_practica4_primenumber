package aco_practica4;

class PrimeNumberAnalizer {
    private int n;
    private int m;
    
    public PrimeNumberAnalizer(int n, int m) {
        this.n = n;
        this.m = m;
        
        System.out.println("[+] PRUEBA : Número impar");
        
        if(!isImpar(n))
            System.out.println("\t[+] Error : " + n + " no es un número impar.");
        else
            System.out.println("");
    }
    
    
    
    boolean exec() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private boolean isImpar(int n) {
        if(n%2 == 0)
            return true;
        
        return false;
    }
}
