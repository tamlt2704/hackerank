package projecteuler;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Euler006 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(squareDiff(n));
        }
    }

    private static long squareDiff(int n) {
        long s1 = n * (n + 1) / 2; // long is important. failed with int
        long s2 = 1;
        for (int i = 2; i <= n; i++) {
            s2 += i * i;
        }

        return Math.abs(s1*s1 - s2);
    }
}
