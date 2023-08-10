package projecteuler;

import java.util.Scanner;

public class Euler002 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
//        int t = 1;
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
//            long n = 100;
            System.out.println(sol(n));
        }
    }

    /*
    If we only write the even numbers of the Fibonacci series:
    2 8 34 144
    E(n) = 4*E(n-1) + E(n-2)
     */
    private static long sol(long n) {
        long a = 2;
        long b = 8;
        long c = 34;
        long sum = 10;
        while (c < n) {
            sum += c;
            a = b;
            b = c;
            c = 4 * b + a;
//            System.out.println(c);
        }
        return sum;
    }
}