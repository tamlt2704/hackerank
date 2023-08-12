package projecteuler;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler005 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(smallestDivisibleByAllInRange(n));
        }
    }

    /*
    Assume we are looking for a number which is divisible by all numbers from 1 to 10. Lets think about what factors that number has.
    Certainly it has all the primes in the range as factors, so lets start with 2*3*5*7 = 210.
    What numbers between 1 and 10 are 210 divisible by? It's divisible by 1, 2, 3, 5, 6, 7 and 10, so we're only missing 4, 8 and 9.
    And you can see why: 4 = 2*2 and 8 = 2*2*2, but there's only one factor of 2 in the problem.
    We need three to cover all the bases, so lets add them in to get 2*2*2*3*5*7 = 840.
    Same argument for 9, which is 3*3, so we have to add in a factor of 3. So we get 2*2*2*3*3*5*7 = 2520

    Here are examples for smaller ranges
    1..6 -> 2^2 * 3^1 * 5^1
    1..8 -> 2^3 * 3^1 * 5^1 * 7^1
    1..10 -> 2^3 * 3^2 * 5^1 * 7^1
     */
    public static int smallestDivisibleByAllInRange(int n) {
        int res = 1;
        for (int i = 2; i <=n; i++) {
            res = res * i / gcd(res, i);
        }
        return res;
    }

    private static int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
