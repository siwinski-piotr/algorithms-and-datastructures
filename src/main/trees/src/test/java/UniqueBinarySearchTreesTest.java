import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueBinarySearchTreesTest {

    @Test
    void t1() {
        // given
        int n = 3;

        // when
        int result = new UniqueBinarySearchTrees.Solution().numTrees(n);

        // then
        assertEquals(5, result);
    }

    @Test
    void t2() {
        // given
        int n = 4;

        // when
        int result = new UniqueBinarySearchTrees.Solution().numTrees(n);

        // then
        assertEquals(14, result);
    }
}