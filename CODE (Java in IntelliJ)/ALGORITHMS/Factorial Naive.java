package Factorial;

public class Factorial {
    static int Factorials(int n){
        if (n == 0) return 1;
        System.out.println(n + "\t");
        return n * Factorials((n-1));
    }

    public static void main(String[] args) {
        Factorials(500);
    }
}
