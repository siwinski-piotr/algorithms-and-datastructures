import java.util.Scanner;

public class Nawiasowania {

    static int generate(int n) {
        int left = 0;
        int right = n;
        int totalSum = 0;
        int k = 0;
        // bin search który znajduje pierwszą mniejszą liczbę lub dokładnie tyle ile trzeba!
        while (left <= right) {
            int mid = (left + right) / 2;

            totalSum = (1 + mid) * mid / 2;

//            System.out.println("mid = " + mid + ", wygeneruje: " + totalSum + " wyrażeń");
            if (totalSum > n) {
                right = mid - 1;
            } else if (totalSum < n) {
                k = mid;
                left = mid + 1;
            } else {
                k = mid;
                break;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int totalSum = 0;
        while (n > 0) {
            int k = generate(n);
            totalSum = (1 + k) * k / 2;
            for (int i = 0; i < k; i++) {
                System.out.println("()");
            }
            System.out.println(")");
            n -= totalSum;
        }
    }
}
