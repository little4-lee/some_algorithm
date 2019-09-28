package string;

/**
 * 14. Longest Common Prefix
 * https://leetcode.com/problems/longest-common-prefix/
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * <p>
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 */
public class L14 {

    public String longestCommonPrefix (String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];

        //前两个的公共前缀
        String common = findCommonPrefix(strs[0], strs[1]);

        for (int i = 2; i < strs.length; i++) {
            common = findCommonPrefix(strs[i], common);
            if (common == null) break;
        }

        return common;
    }

    private String findCommonPrefix (String strA, String strB) {
        if (strA == null || strB == null) return null;

        int length = Math.min(strA.length(), strB.length());
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (strA.charAt(i) == strB.charAt(i)) {
                index++;
            } else break;
        }
        return strA.substring(0, index);
    }

    public static void main (String[] args) {
        //        String[] strings = {"abcdefg", "abc", "abcdefghi"};
        String[] strings = {"abcdefg", "abc", "abcdefghi"};
        //        String[] strings = {"abcdefg", "abcdefghi", "abc", "abcdefg", "d"};
        //        String[] strings = {};
        System.out.println(new L14().longestCommonPrefix(strings));
    }
}
