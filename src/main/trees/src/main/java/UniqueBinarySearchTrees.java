public class UniqueBinarySearchTrees {

    // https://algo.monster/liteproblems/96
    static class Solution {
        public int numTrees(int n) {
            int[] dp = new int[n + 1];

            dp[0] = 1;
            for (int nodeCount = 1; nodeCount <= n; nodeCount++) {
//                System.out.println("Calc for nodeCount = " + nodeCount);
                for (int root = 0; root < nodeCount; root++) {
                    int rightSubtreeSize = nodeCount - root - 1;
                    int i = dp[root] * dp[rightSubtreeSize];

//                    System.out.println(
//                            "Take %s as root value. Total trees: %s. Right subtree size: %s. dp[%s] = %s, dp[%s] = %s"
//                            .formatted(root + 1, i, rightSubtreeSize, root, dp[root], rightSubtreeSize, dp[rightSubtreeSize]));
                    dp[nodeCount] += i;
                }
//                System.out.println("Calculated state for count = %s = %s".formatted(nodeCount, dp[nodeCount]));
            }
            return dp[n];
        }

    }


}
