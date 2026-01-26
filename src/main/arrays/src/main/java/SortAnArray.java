import java.util.Arrays;

public class SortAnArray {

    class Solution {

        static void mergesort(int left, int right, int[] nums) {
            if (left < right) {
                int mid = (left + right) / 2;
                mergesort(left, mid, nums);
                mergesort(mid + 1, right, nums);

                merge(left, mid, right, nums);
            }
        }

        static void merge(int left, int mid, int right, int[] nums) {
            int l = left;
            int r = mid + 1;
            int[] tmp = new int[right - left + 1];

            int k = 0;
            while (l <= mid && r <= right) {
                if (nums[l] < nums[r]) {
                    tmp[k] = nums[l];
                    l++;
                } else {
                    tmp[k] = nums[r];
                    r++;
                }
                k++;
            }

            // finished left sub array
            while (l <= mid) {
                tmp[k++] = nums[l++];
            }

            while (r <= right) {
                tmp[k++] = nums[r++];
            }

            for (int i = 0; i < tmp.length; i++) {
                nums[i + left] = tmp[i];
            }
        }

        public int[] sortArray(int[] nums) {
            mergesort(0, nums.length - 1, nums);

            return nums;
        }
    }

    public static void main(String[] args) {
        var nums = new int[]{-2,3,-5};
        int[] ints = new SortAnArray().new Solution().sortArray(nums);

        System.out.println(Arrays.toString(ints));
    }

}
