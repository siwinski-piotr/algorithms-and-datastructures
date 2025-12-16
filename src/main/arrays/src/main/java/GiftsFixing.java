import java.util.Arrays;
import java.util.Scanner;

// https://codeforces.com/problemset/problem/1399/B
public class GiftsFixing {


    static long equalizeGifts(int[] candies, int[] oranges) {

        int minC = candies[0];
        int minO = oranges[0];

        for (var v: candies) {
            minC = Math.min(minC, v);
        }

        for (var v: oranges) {
            minO = Math.min(minO, v);
        }

        long operations = 0;
        for (int i = 0; i < candies.length; i++) {
            int diff_C = candies[i] - minC;
            int diff_O = oranges[i] - minO;

            operations += Math.max(diff_C, diff_O);

        }
        return operations;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int testsNo = scanner.nextInt();


        // read all test cases
        for (int i = 0; i < testsNo; i++) {

            // read single test case
            int giftsNumber = scanner.nextInt();
            int[] candies = new int[giftsNumber];
            int[] oranges = new int[giftsNumber];
            for (int j = 0; j < giftsNumber; j++) {
                candies[j] = scanner.nextInt();
            }
            for (int j = 0; j < giftsNumber; j++) {
                oranges[j] = scanner.nextInt();
            }

            System.out.println(equalizeGifts(candies, oranges));

        }
    }
}
