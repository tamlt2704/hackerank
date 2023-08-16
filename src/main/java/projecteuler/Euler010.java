package projecteuler;

import java.util.Arrays;
import java.util.Scanner;

public class Euler010 {
    public static void main(String[] args) {
        int max_n = 1000000;
        int[] primes = new int[max_n];
        long[] sumToN = new long[max_n];
        Arrays.fill(primes, 1);
        sumToN[0] = 0;
        sumToN[1] = 1;

        for (int i = 2; i < Math.sqrt(max_n); i++) {
            if (primes[i] == 1) {
                for (int j = i*i; j < max_n; j+=i) {
                    primes[j] = 0;
                }
            }
        }
        for (int i = 3; i < max_n; i++) {
            sumToN[i] = primes[i] == 1 ? sumToN[i - 1] + i : sumToN[i - 1];
        }

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(sumToN[n]);
        }
        /*System.out.println(sumPrimeLessThan(5, primes, marked));
        System.out.println(sumPrimeLessThan(10, primes, marked));*/
    }

    private static long sumPrimeLessThan(int n, int[] primes, int[] marked) {
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (primes[i] == 1) {
                sum += i;

                if (marked[i] == 0) {
                    for (int j = i+i; j <1000000; j+=i) {
                        primes[j] = 0;
                        marked[j] = 1;
                    }
                    marked[i] = 1;
                }
            }
        }
        return sum;
    }
}
