package projecteuler;

import java.util.Scanner;

public class Euler008 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int k = in.nextInt();
            String num = in.next();
            System.out.println(maxConsecutiveProduct(num, n, k));
        }

        /*System.out.println(maxConsecutiveProduct("3675356291", 10, 5));
        System.out.println(maxConsecutiveProduct("2709360626", 10, 5));
        System.out.println(maxConsecutiveProduct("1112", 4, 1));*/
    }

    public static int maxConsecutiveProduct(String num, int n, int k) {
        int max = 0;
        for (int i = 0; i < n - k + 1; i++) {
            int prod = 1;
            for (int j = 0; j < k; j++) {
                prod *= num.charAt(i + j) - '0';
            }
            if (prod > max) {
                max = prod;
            }
        }
        return max;

        /*int max = 0;
        if (k > n) {
            return max;
        }
        int j = 0;
        int cummulativeProduct = 1;
        for (int i = 0; i < n - k + 1; i++) {
            cummulativeProduct *= num.charAt(i) - '0';

            if (i >= k) {
                cummulativeProduct = cummulativeProduct == 0 ? 0 : cummulativeProduct / (num.charAt(j) - '0');
                j++;
                max = max < cummulativeProduct ? cummulativeProduct : max;
            }
        }
        return max;*/
    }
}
