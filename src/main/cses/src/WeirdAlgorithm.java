import java.util.Scanner;

public class WeirdAlgorithm {

    static String solution(long n) {
        StringBuilder builder = new StringBuilder();
        builder.append(n).append(" ");

        while (n > 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = n * 3 + 1;
            }
            builder.append(n).append(" ");
        }

        return builder.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String solution = solution(n);
        System.out.println(solution);
    }
}
