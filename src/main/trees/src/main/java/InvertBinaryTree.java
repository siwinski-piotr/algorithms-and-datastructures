import java.util.Stack;

public class InvertBinaryTree {

    public static class Solution {
        public TreeNode invertTree(TreeNode root) {
            invert(root);
            return root;
        }

        private void invert(TreeNode node) {
            if (node == null) {
                return;
            }

            var tmp = node.left;
            node.left = node.right;
            node.right = tmp;

            invert(node.left);
            invert(node.right);
        }

        public TreeNode invertTreeIter(TreeNode root) {

            if (root == null) {
                return null;
            }

            var stack = new Stack<TreeNode>();
            stack.push(root);

            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();

                if (node == null) {
                    continue;
                }

                var tmp = node.left;
                node.left = node.right;
                node.right = tmp;

                stack.push(node.right);
                stack.push(node.left);

            }
            return root;
        }
    }
}
