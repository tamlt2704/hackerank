package projecteuler;

import java.util.Scanner;

public class Euler009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
        }
//        System.out.println(tripletPythagore(4));
    }

    /*
        a * a + b * b = c * c
        a < b < c
        and
        a + b + c = n

        a < n / 3 + 1
        b < n / 2 - 1

        a * a + b * b   = c * c
        a*a + 2ab + b*b = c*c + 2ab
        (a+b)^2         = c*c + 2ab
        2ab             = (a+b)^2 - c*c
                        = (n-c)^2 - c*c (1)

        and
            a^2 - 2ab + b^2 = c^2 - (1)
                            = c^2 - (n-c)^2 + c*c
                 (a-b)^2    = c^2 - n^2 + 2nc
     */

    public static long tripletPythagore(int n) {
        for (int c = n/3+1; c < n/2; c++) {
            long sqa_b = c * c - n * n + 2 * n * c;
            long a_b = (int) Math.floor(Math.sqrt(sqa_b));

            if (a_b * a_b == sqa_b) {
                long b = (n - c + a_b) / 2;
                long a = n - b - c;
                return a * b * c;
            }
        }
        return -1;
    }
}
