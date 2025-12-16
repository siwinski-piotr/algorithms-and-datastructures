public class ReverseString {
    static class Solution {


        // a b c d  -> d c b a
        // 1 2 3 4 5  -> 5 4 3 2 1
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length - 1;

            while (left < right) {
                char tmp = s[left];
                s[left] = s[right];
                s[right] = tmp;
                left++;
                right--;
            }


        }
    }

    public static void main(String[] args) {
        char[] chars = {'h', 'e', 'l', 'l', 'o'};
        new Solution().reverseString(chars);

        System.out.println(chars);
    }
}
