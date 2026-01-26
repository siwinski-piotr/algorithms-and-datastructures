import java.util.Arrays;
import java.util.Scanner;

public class LowestSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.next();
        int n = sc.nextInt();


        // sortowanie przez zliczanie...

        int[] sorted = new int[10];
        for (int i = 0; i < digits.length(); i++) {
            int digit = Integer.parseInt(digits.substring(i, i + 1));
            sorted[digit]++;
        }

        // tablica z liczbami
        String[] resultNumbers = new String[n];
        Arrays.fill(resultNumbers, "");
        var resultIndex = 0;

        // mam do obstawienia tyle pozycji ile jest digits (cyferek w napisie)
        for (int i = 0; i < digits.length(); i++) {
            var currentNumber = resultNumbers[resultIndex % resultNumbers.length];

            // find appropriate number - lowest available number
            int digit = 0;
            if (currentNumber.length() == 0) { // empty string, can't take 0 for start
                digit = 1;
            }
            int lowestDigit = 0;
            // check if digit is available to use
            while (digit < sorted.length) {
                if (sorted[digit] > 0) {
                    lowestDigit = digit;
                    sorted[digit]--;
                    break;
                }
                digit++;
            }

            currentNumber = currentNumber + lowestDigit;
            resultNumbers[resultIndex % resultNumbers.length] = currentNumber;
            resultIndex++;
        }

        int totalSum = 0;
        for (var num : resultNumbers) {
            totalSum += Integer.parseInt(num);
        }
        System.out.println(Arrays.toString(resultNumbers));
        System.out.println(totalSum);
    }
}
