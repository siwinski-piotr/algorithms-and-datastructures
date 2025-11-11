import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class IncreasingArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());

        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());

        long modNumber = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1) > list.get(i)) {
                modNumber += list.get(i - 1) - list.get(i);
//                System.out.println("%s > %s. Adding: %s".formatted(list.get(i - 1), list.get(i), modNumber));
                list.set(i, list.get(i - 1));
            }
        }
        System.out.println(modNumber);
    }
}
