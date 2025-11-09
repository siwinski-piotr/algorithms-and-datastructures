public class DiameterOfBinaryTree {

    static class Solution {

        private int maxDiameter = 0;
        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return maxDiameter;
        }

        private int dfs(TreeNode node) {
            if (node == null) {
                return 0;
            }

            int left = dfs(node.left);
            int right = dfs(node.right);

            maxDiameter = Math.max(maxDiameter, left + right);
            return 1 + Math.max(left, right);
        }
    }
}
