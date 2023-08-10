package projecteuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;


public class Euler003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            long n = in.nextLong();
            System.out.println(largestPrimeFactor(n));
        }
    }

    /*
    a composite number n can be represent as a product of 2 factors: x = factor * other
    assume factor is a prime number and factor <= number. There are 2 options
    1. other can be a prime -> other is the largest prime factor
    2. continue the process by setting x = other
     */
    public static long largestPrimeFactor(long n) {
        for (long factor = 2; factor*factor <= n ; factor++) {
            while ((n % factor == 0) && (n != factor)) {
                n /= factor;
            }
        }
        return n;
    }
}
