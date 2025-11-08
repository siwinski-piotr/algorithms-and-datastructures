import org.junit.jupiter.api.Test;

class InvertBinaryTreeTest {

    @Test
    void shouldInvertBinaryTree() {
        // given

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        // when
        TreeNode treeNode = new InvertBinaryTree.Solution().invertTree(root);

        // then
        System.out.println(treeNode);

    }

    @Test
    void shouldInvertBinaryTreeIteratively() {
        // given

        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        root.right = new TreeNode(7, new TreeNode(6), new TreeNode(9));

        // when
        TreeNode treeNode = new InvertBinaryTree.Solution().invertTreeIter(root);

        // then
        System.out.println(treeNode);

    }
}