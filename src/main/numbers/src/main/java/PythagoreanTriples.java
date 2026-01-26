import java.util.Scanner;

public class PythagoreanTriples {

    // https://codeforces.com/problemset/problem/707/C

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        if (n == 1 || n == 2) {
            System.out.println(-1);
            return;
        }

        if (n % 2 == 1) {
            // n jest nieparzyste
            long m = (n * n - 1) / 2;
            long k = (n * n + 1) / 2;
            System.out.println(m + " " + k);
        } else {
            // n jest parzyste
            long t = n / 2;
            long m = t * t - 1;
            long k = t * t + 1;
            System.out.println(m + " " + k);
        }
    }

}
