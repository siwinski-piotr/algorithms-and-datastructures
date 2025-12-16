import java.util.List;

public class CountBitsInInteger {

    // O(n)
    static int countBits(int x) {
        int bitCount = 0;
        while (x != 0) {
            bitCount += (x & 1);
            x = x >> 1;
        }
        return bitCount;
    }


    public static void main(String[] args) {

        var testValues = List.of(
                1, 2, 3, 4, 127, 128, 1023, 1024, Integer.MAX_VALUE
        );
        for (var v : testValues) {
            System.out.printf("number: %d -- java bit count: %d  -- binary string: %s  -- test bit count: %d%n",
                    v, Integer.bitCount(v), Integer.toBinaryString(v), countBits(v));
        }


        System.out.println("------------------------------");
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(Integer.toBinaryString(Integer.MAX_VALUE));

        System.out.println("------------------------------");
        System.out.println(Integer.toBinaryString(-43));
        System.out.println(" " + Integer.toBinaryString(Integer.MAX_VALUE - 43 + 1));


    }


}
