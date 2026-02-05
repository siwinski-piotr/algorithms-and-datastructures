import java.util.Scanner;

public class SumOfCubes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            long x = scanner.nextLong();
            if (canBeRepresentedAsSumOfCubes(x)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        scanner.close();
    }

    static boolean canBeRepresentedAsSumOfCubes(long x) {
        // Maksymalna wartość a to pierwiastek sześcienny z x
        long maxA = (long) Math.cbrt(x);

        // Iterujemy przez wszystkie możliwe wartości a od 1
        for (long a = 1; a <= maxA; a++) {
            long aCubed = a * a * a;
            long remainder = x - aCubed;

            if (remainder <= 0) break;

            // Używamy binary search do znalezienia b
            if (isCube(remainder)) {
                return true;
            }
        }

        return false;
    }

    // Binary search do sprawdzenia czy n jest sześcianem
    static boolean isCube(long n) {
        if (n < 1) return false;

        long low = 1;
        long high = (long) Math.cbrt(n) + 2; // +2 dla bezpieczeństwa zaokrągleń

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long cube = mid * mid * mid;

            if (cube == n) {
                return true;
            } else if (cube < n) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}