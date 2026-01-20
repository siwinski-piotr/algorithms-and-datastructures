import java.util.Arrays;

public class CountingBits {

    class Solution {
        public int[] countBits(int n) {
            int[] result = new int[n + 1];
            for (int number = 0; number <= n; number++) {

                int bitCount = 0;
                for (int i = 0; i < 32; i++) {
                    if ((1 << i & number) != 0) {
                        bitCount++;
                    }
                }
                result[number] = bitCount;
            }
            return result;
        }
    }

    class BrianKerninghanAlgorithm {
        public int[] countBits(int n) {
            int[] res = new int[n + 1];

            for (int i = 0; i <= n; i++) {

                int num = i;
                int bitCount = 0;
                while (num > 0) {
                    num = num & (num - 1);
                    bitCount++;
                }
                res[i] = bitCount;
            }
            return res;
        }
    }

    class CountingBitsDP {
        public int[] countBits(int n) {
            int[] DP = new int[n + 1];

            int highestPowerOf2 = 1;

            for (int i = 1; i <= n; i++) {

                if (highestPowerOf2 * 2 == i) {
                    System.out.println("New highest power of 2:" + highestPowerOf2);
                    highestPowerOf2 = i;
                }
                // np. 13 = 8 + 5
                //    1101 = 1000 + 0101
                // every power of 2 has 1 bit
                // let's get other bit count from remainder
                // that's already calculated
                DP[i] = 1 + DP[i - highestPowerOf2];
            }
            return DP;
        }
    }

    class OptimalCountingDP {
        public int[] countBits(int n) {
            int[] dp = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dp[i] = (n & 1) + dp[i >> 1];
                //  dp[7] = 7&1
                // dp[111]= 111&1 + dp[11]
                //        = 1 +     dp[3]

            }
            return dp;
        }
    }


    public static void main(String[] args) {
        Solution solution = new CountingBits().new Solution();
        int[] ints = solution.countBits(5);


        System.out.println(Arrays.toString(ints));
    }
}
