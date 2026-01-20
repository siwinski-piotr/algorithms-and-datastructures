public class FindSingleNumberInArrayXor {

    static class Solution {
        public int singleNumber(int[] nums) {
            int res = 0;
            for (int n : nums) {
                res ^= n;
            }
            
            return res;
        }
    }

    public static void main(String[] args) {


        int i = new Solution().singleNumber(new int[]{2, 2, 1});

        System.out.println(i);
    }
}
