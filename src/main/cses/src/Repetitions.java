import java.util.Scanner;

public class Repetitions {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int maxLen = 0;

        int currentLen = 0;
        char currentChar = s.charAt(0);

        for (char c : s.toCharArray()) {
            if (c == currentChar) {
                currentLen++;
                continue;
            }
            maxLen = Math.max(maxLen, currentLen);
            currentChar = c;
            currentLen = 1;
        }
        System.out.println(Math.max(maxLen, currentLen));
    }
}
