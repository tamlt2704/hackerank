package projecteuler;

import java.util.*;

public class Euler001 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            n = n - 1; // below n
            /*
            TLE
            System.out.println(IntStream.range(1, n)
                    .filter(i -> (i % 3 == 0) || (i % 5 == 0))
                    .sum());*/
            System.out.println(sum(n, 3) + sum(n, 5) - sum(n, 15));
        }
    }

    /*
    There are [N/3][N/3] numbers between 1 and N that are divisible by 3
    S3 = 3 + 6 + 9 + ....
    = 3 (3/3 + 6/3 + 9/3)
    = 3 (1 + 2 + 3 +...)
    = 3 (n/3)(n/3+1) / 2

    Similarly
    S5 = 5 (n/5)(n/5+1) / 2

    Sun of all common multiplies
    S15 = 15 (n/15)(n/15+1) / 2

    Sum of multiplies of 3 or 5
    S = S3+S5-S15
     */
    static long sum(long n, int k) {
        long n2 = n / k;
        return k * n2 * (n2 + 1) / 2;
    }
}