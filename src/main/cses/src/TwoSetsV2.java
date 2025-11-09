import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSetsV2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        long totalSum = ((1L + n) * n) / 2;

        if (totalSum % 2 == 1) {
            System.out.println("NO");
            return;
        }

        System.out.println("YES");
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        boolean[] visited = new boolean[n + 1];

        long set1Sum = 0;
        int maxElement = n;

        long mid = totalSum / 2;

        while (set1Sum < mid) {
            long remainingSum = mid - set1Sum;

            if (remainingSum > maxElement) {
                set1.add(maxElement);
                visited[maxElement] = true;
                set1Sum += maxElement;
                maxElement--;
            } else {
                set1.add((int) remainingSum);
                visited[Math.toIntExact(remainingSum)] = true;
                set1Sum += remainingSum;
            }
        }

        for (int i = 1; i < visited.length; i++) {
            if (!visited[i]) {
                set2.add(i);
            }
        }

        var builder = new StringBuilder();
        builder.append(set1.size()).append("\n");

        for (var elem : set1) {
            builder.append(elem).append(" ");
        }
        builder.append("\n");

        builder.append(set2.size()).append("\n");
        for (var elem : set2) {
            builder.append(elem).append(" ");
        }
        System.out.println(builder.toString());
    }
}