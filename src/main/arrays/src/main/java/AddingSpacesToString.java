public class AddingSpacesToString {

    static class Solution {
        public String addSpaces(String s, int[] spaces) {


            var builder = new StringBuilder();

            int spacesIndex = 0;

            int sIndex = 0;

            while (sIndex < s.length() && spacesIndex < spaces.length) {

                if (sIndex == spaces[spacesIndex]) {
                    builder.append(" ");
                    spacesIndex++;
                }

                builder.append(s.charAt(sIndex));
                sIndex++;
            }

            if (sIndex < s.length()) {
                builder.append(s.substring(sIndex));
            }

            return builder.toString();
        }
    }

    public static void main(String[] args) {
        String s = new Solution().addSpaces("EnjoyYourCoffee", new int[]{5, 9});

        System.out.println(s);


    }
}
