import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

    @Test
    void t1() {


        TreeNode root = new TreeNode(1, new TreeNode(2), null);
        int i = new DiameterOfBinaryTree.Solution().diameterOfBinaryTree(root);

        Assertions.assertEquals(1, i);
    }
}