public class ReverseInteger {

    class Solution {
        public int reverse(int x) {
            boolean isPositive = x >= 0;

            x = Math.abs(x);
            long reversed = 0;
            while (x > 0) {
                int remainder = x % 10;
                reversed = reversed * 10 + remainder;
                x = x / 10;

                if (reversed > Integer.MAX_VALUE) {
                    return 0;
                }
            }

            if (!isPositive) {
                reversed = reversed * -1;
            }

            return Math.toIntExact(reversed);
        }
    }

    public static void main(String[] args) {
        int x = 120;
        int reverse = new ReverseInteger().new Solution().reverse(x);

        System.out.println(reverse);

    }
}
