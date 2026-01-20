
// https://codeforces.com/problemset/problem/870/C

import java.util.Scanner;

public class MaximumSplitting {

    /*
1 -> no answer
2 -> no answer
3 -> no answer
4 -> 1 liczba (4)
5 -> no answer
6 -> 1 liczba
7 -> no answer
8 -> 2 numbers (4 + 4)
9 -> 1 number (9)
10 -> 2 numbers - 4 + 6
11 -> no answer
12 -> 3 numbers (4 + 4 + 4)
13 -> 2 numbers (4 + 9)
14 -> 3 numbers (4 + 4 + 6)
15 -> 2 numbers (9 + 6)
*/
    public static int maxSplitting(int number) {

        // handle edge cases: for 1,2,3, 5 & 7 -> no answer
        if (number < 4 || number == 5 || number == 7 || number == 11) {
            return -1;
        }

        // group number by division of 4
        if (number % 4 == 0) {
            return number / 4;
        }

        if (number % 4 == 1) {
            // numbers like 13, 17, 21, 25
            // ex. 13 - 9 = 4;
            // (17 - 9) / 4 + 1 ; one accounts for 9
            return (number - 9) / 4 + 1;
        }

        if (number % 4 == 2) {
            return (number - 6) / 4 + 1;
        }

        if (number % 4 == 3) {
            return (number - 9 - 6) / 4 + 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        var scanner = new Scanner(System.in);
        int queries = scanner.nextInt();

        for (int i = 0; i < queries; i++) {
            int number = scanner.nextInt();
            System.out.println(maxSplitting(number));
        }
    }
}
