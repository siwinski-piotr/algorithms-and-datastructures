import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonPrefixTest {

    @Test
    void shouldFindCommonPrefix() {
        // given
        String[] strings = {
                "flower", "flow", "flight"
        };

        // when
        String s = new LongestCommonPrefix.Solution().longestCommonPrefix(strings);

        // then
        assertEquals("fl", s);
    }

    @Test
    void shouldReturnEmptyStringWhenNoCommonPrefix() {
        // given
        String[] strings = {
                "dog", "racecar", "car"
        };

        // when
        String s = new LongestCommonPrefix.Solution().longestCommonPrefix(strings);

        // then
        assertEquals("", s);
    }

}