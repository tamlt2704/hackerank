package projecteuler;

import java.util.Arrays;
import java.util.Scanner;

public class Euler007 {
    public static void main(String[] args) {
        int maxNumber = 104743;
        int[] isPrime = new int[maxNumber];
        Arrays.fill(isPrime, 1);
        isPrime[0] = 0;
        isPrime[1] = 0;

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(nthPrime(n, isPrime, maxNumber));
        }

//        System.out.println(nthPrime(3, isPrime, maxNumber));//5
//        System.out.println(nthPrime(6, isPrime, maxNumber));//13
//        System.out.println(nthPrime(10));//29
    }

    private static int nthPrime(int n, int[] isPrime, int maxNumber) {
        int count = 0;
        int i = 1;
        int res = 0;
        while (i < maxNumber) {
            i++;
            if (isPrime[i] == 1) {
                count++;
                res = i;

                for (int j = i+i; j < maxNumber; j+=i) {
                    isPrime[j] = 0;
                }
            }
            if (count >= n) {
                return res;
            }
        }
        return res;
    }
}
