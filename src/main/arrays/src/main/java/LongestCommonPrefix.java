public class LongestCommonPrefix {
    /**
     * https://leetcode.com/problems/longest-common-prefix/
     */

    /**
     * Notes
     * 1. Shortest string is potentially the longestCommonPrefix. Meaning there is no longer prefix than shortest string from strs array.
     */
    static class Solution {
        public String longestCommonPrefix(String[] strs) {

            if (strs.length == 0) {
                return "";
            }
            if (strs.length == 1) {
                return strs[0];
            }

            var shortestString = strs[0];
            // find shortest string
            for (var s : strs) {
                if (shortestString.length() > s.length()) {
                    shortestString = s;
                }
            }

            // compare shortest string with other candidates
            int maxPrefix = shortestString.length();
            for (String currentString : strs) {
                for (int j = 0; j < shortestString.length(); j++) {
                    if (shortestString.charAt(j) != currentString.charAt(j)) {
                        maxPrefix = Math.min(j, maxPrefix);
                        break;
                    }

                }
                if (maxPrefix == 0) {
                    return "";
                }
            }
            return shortestString.substring(0, maxPrefix);
        }

    }
}
