import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfThreeNumbersTest {

    @ParameterizedTest
    @CsvSource(value = {
            "64,'YES\n2 4 8'",
            "32,NO",
            "97,NO",
            "2,NO",
            "12345,'YES\n3 5 823'"
    })
    void test1(String input, String expected) {
        // given
        var n = Integer.parseInt(input);

        // when
        String result = ProductOfThreeNumbers.productOfThreeNumbersFactorization(n);

        // then
        assertEquals(result, expected);
    }
}