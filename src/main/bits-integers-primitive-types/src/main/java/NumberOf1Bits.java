public class NumberOf1Bits {

    static class Solution {
        public int hammingWeight(int n) {


            int count = 0;

            // 1001   -n
            // 0001   1 << idx

//            System.out.println("Going to check: " + Integer.toBinaryString(n));
            for (int idx = 0; idx < 32; idx++) {

//                System.out.println("current num: " + Integer.toBinaryString((1 << idx)));

//                System.out.println("result: " + Integer.toBinaryString((n & (1 << idx))));
//                System.out.println();
                if ((n & (1 << idx)) > 0) {
                    count++;
                }
            }

            return count;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(11));
        System.out.println(new Solution().hammingWeight(128));
        System.out.println(new Solution().hammingWeight(2147483645));
    }
}
