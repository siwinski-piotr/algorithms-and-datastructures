import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MissingNumber {

    static int findMissingNumber(List<Integer> list) {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            long mid = ((long) (left + right)) / 2;

            if (list.get((int) mid) != mid + 1) {
                right = (int) mid - 1;
            } else {
                left = (int) mid + 1;
            }
        }
        return left + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        List<Integer> numbers = new java.util.ArrayList<>(Arrays.stream(sc.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList()));

        Collections.sort(numbers);

        int missingNumber = findMissingNumber(numbers);

        System.out.println(missingNumber);

    }
}
