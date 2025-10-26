import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Link: https://codeforces.com/problemset/problem/1294/C
 */
public class ProductOfThreeNumbers {

    // Solution in O(sqrt(n,3) * n) complexity
    public static String productOfThreeNumbersV1(int N) {
        int a = 2;
        while (a * a * a <= N) {
            for (int b = a + 1; b <= N; b++) {
                if (N % (a * b) == 0) {
                    int c = N / (a * b);
                    if (a == c || b == c || c < 2) continue;
                    return "YES\n%s %s %s".formatted(a, b, c);
                }
            }
            a++;
        }
        return "NO";
    }

    // Solution in O(sqrt(n)) complexity
    public static String productOfThreeNumbersFactorization(int n) {
        var factors = factorization(n);

        // sprawdzenie
        // Case 1: >= 3 różynch czynników
        var set = new LinkedList<>(new HashSet<>(factors));
        if (factors.size() < 3) {
            return "NO";
        }

        if (set.size() >= 3 || (set.size() == 2 && factors.size() >= 4)) {
            int a = set.get(0);
            factors.remove((Integer) a);
            int b = set.get(1);
            factors.remove((Integer) b);

            int c = 1;

            for (var rest : factors) {
                c *= rest;
            }

            return "YES\n%s %s %s".formatted(a, b, c);
        } else if (set.size() == 1 && factors.size() >= 6) {
            int a = factors.get(0);
            factors.remove((Integer) a);

            int b = factors.get(1) * factors.get(2);
            factors.remove((Integer) a);
            factors.remove((Integer) a);

            int c = 1;
            for (var rest : factors) {
                c *= rest;
            }
            return "YES\n%s %s %s".formatted(a, b, c);
        }
        return "NO";
    }

    private static List<Integer> factorization(int n) {
        List<Integer> factors = new ArrayList<>();

        // Check division by 2
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check division by 3 and other odd factors
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If n > 2, then n is prime number
        if (n > 2) {
            factors.add(n);
        }
        return factors;
    }


    public static void main(String[] args) throws IOException {
        var reader = new BufferedReader(new InputStreamReader(System.in));

        String line = reader.readLine();
        int totalNumbers = Integer.parseInt(line);

        var lst = new ArrayList<String>();
        int current = 0;
        while (current < totalNumbers) {
            lst.add(reader.readLine());
            current++;
        }

        var buff = new StringBuilder();
        for (var elem : lst) {
            int number = Integer.parseInt(elem);
            buff.append(ProductOfThreeNumbers.productOfThreeNumbersFactorization(number)).append("\n");
        }
        System.out.println(buff);
    }
}
