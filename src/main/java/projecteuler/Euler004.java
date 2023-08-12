package projecteuler;
import java.util.*;

public class Euler004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            System.out.println(largestPalindromeNumber(n));
        }
//        System.out.println(largestPalindromeNumber(800000));// 793397
//        System.out.println(largestPalindromeNumber(101101));// 793397
    }

    /*
    Let x be one 3 -digit number and let y be the other
    Observe that the product of two 3-digit numbers will be either a 5 or 6 -digit number.
    Further, if such numbers were palindromes, they could be expressed in base 10 in one of the following two ways:
        abcba   = 10,000.a + 1,000.b + 100.c + 10.b + a
        abccba  = 100,000.a + 10,000b + 1,000.c + 100.c + 10.b + a
    Since we are looking for a maximal product, we assume that is a 6-digit (abccba)
        abccba  = 100,000.a + 10,000b + 1,000.c + 100.c + 10.b + a
                = 100,001.a + 10,010b + 1,100.c
                = 11 (9091.a + 910.b + 10.c) = p.q
                (p, q is 3 digits number)
        => p * q must be divisible by 11
        => either p or q is divisible by 11. start from 990 because it is the largest possible number that divisible by 11
     */
    private static int largestPalindromeNumber(int n) {
        int res = 0;
        for (int i = 990; i >= 100 ; i-=11) {
            for (int j = 999; j >= 100; j--) {
                int prod = i * j;
                if ((prod > res) && (prod < n) && is_palindrome(prod) ) {
                    res = prod;
                    break; // terminated earlier
                } else if (res > prod) {
                    break; // terminated earlier
                }
            }
        }
        return res;
    }

    private static boolean is_palindrome(int orgNumber) {
        int reversed = 0;
        int number = orgNumber;
        while (number > 0) {
            reversed = reversed * 10 + number % 10;
            number /= 10;
        }
        return (reversed == orgNumber) || (orgNumber == number / 10);
    }
}
