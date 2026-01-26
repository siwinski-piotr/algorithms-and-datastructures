public class ReverseBits {

    class Solution {
        public int reverseBits(int n) {

            System.out.println(Integer.toBinaryString(n));

            int result = 0;
            for (int i = 0; i < 32; i++) {
                int bit = (n >> i) & 1;
                result |= (bit << (31 - i));
            }


            System.out.println("Result: " + Integer.toBinaryString(result));
            return result;
        }
    }

    public static void main(String[] args) {
        int i = new ReverseBits().new Solution().reverseBits(6);


    }
}
