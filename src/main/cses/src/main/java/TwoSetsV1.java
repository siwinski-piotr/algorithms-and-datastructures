import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoSetsV1 {

    /*
    My algorithm - doesn't work for big numbers...
    I like how list is returned and processed in dfs helper function
     */
    static List<Integer> canSum(List<Integer> nums, int target) {
        Map<String, List<Integer>> map = new HashMap<>();
        return dfs(nums, target, 0, map);
    }

    private static List<Integer> dfs(List<Integer> nums, int target, int index, Map<String, List<Integer>> memo) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0 || index >= nums.size()) {
            return null;
        }

        String key = target + "-" + index;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }

        int currentNumber = nums.get(index);

        // pick this number
        List<Integer> with = dfs(nums, target - currentNumber, index + 1, memo);
        if (with != null) {
            with.add(currentNumber);
            memo.put(key, with);
            // todo: cache result here
            return with;
        }

        // skip current number - no need to remove from list... to check
        List<Integer> without = dfs(nums, target, index + 1, memo);
        // cache...
        memo.put(key, without);
        return without;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int totalSum = ((1 + n) * n) / 2;

        if (totalSum % 2 == 0) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
            return;
        }

        List<Integer> collect = IntStream.range(1, n + 1)
                .boxed()
                .collect(Collectors.toList());


        var allNumbers = new HashSet<>(collect);
        var firstSet = new HashSet<>(canSum(collect, totalSum / 2));

        for (var num: firstSet) {
            allNumbers.remove(num);
        }

        System.out.println(firstSet.size());
        for (var num: firstSet) {
            System.out.print(num + " ");
        }
        System.out.println();
        System.out.println(allNumbers.size());
        for (var num: allNumbers) {
            System.out.print(num + " ");
        }
    }
}


// Fun with division
//        for (n = 1; n < 100; n++) {
//            System.out.println("Result for n = " + n);
//            int result = ((1 + n) * n) / 2;
//            double resultD = (((double) 1 + n) / 2 * n);
//            if (result != resultD) {
//                System.out.println("DIFFERENT");
//            }
//
//            System.out.println("Integer: " + (((1 + n) * n) / 2));
//            System.out.println("Double: " + (((double) 1 + n) / 2 * n)     );
//
//
//        }