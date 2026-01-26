public class MissingNumber {

    class Solution {
        public int missingNumber(int[] nums) {
            boolean[] presentNumbers = new boolean[nums.length + 1];

            for (var num : nums) {
                presentNumbers[num] = true;
            }

            for (int i = 0; i < presentNumbers.length; i++) {
                if (presentNumbers[i] == false) {
                    return i;
                }
            }

            return 0;
        }
    }

    class XorSolution {
        public int missingNumber(int[] nums) {
            int n = nums.length;

            int xor = 0;
            for (int i = 0; i < n; i++) {
                xor = xor ^ i ^ nums[i];
            }

            return xor ^ nums.length;
        }
    }

    public static void main(String[] args) {
        int i = new MissingNumber().new Solution().missingNumber(new int[]{3, 0, 1});

        System.out.println("Missing number is: " + i);
    }
}
