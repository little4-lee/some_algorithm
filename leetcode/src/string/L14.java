package string;

import java.util.ArrayList;
import java.util.List;

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
        if (strs.length == 1) return strs[0];

        //找出前两个的共同短语
        List<String> commons = getCommons(strs[0], strs[1]);

        // 遍历余下的字符串
        List<String> current = new ArrayList<String>();
        for (int i = 2; i < strs.length; i++) {
            current.clear();
            for (String str : commons) {
                List<String> temp = getCommons(strs[i], str);
                if (temp.size() == 0) commons.remove(str);
                else { // > 0
                    if (temp.contains(str)) {
                        //do nothing
                    } else {
                        commons.remove(str);
                        current.addAll(temp);
                    }
                }
            }
            if (current.size() > 0) commons.addAll(current);
        }

        int longestIndex = -1;

        for (int i = 0; i < commons.size(); i++) {
            if (i == 0) longestIndex = i;
            if (commons.get(i).length() > commons.get(longestIndex).length()) longestIndex = i;
        }

        return longestIndex == -1 ? "" : commons.get(longestIndex);
    }

    private List<String> getCommons(String a, String b) {
        List<String> commons = new ArrayList<String>();
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i + count) == b.charAt(j)) {
                    count++;
                } else {
                    if (count == 0) {
                        //do nothing
                    } else {
                        String commonNew = a.substring(i, i + count);
                        if (!commons.contains(commonNew))
                            commons.add(a.substring(i, i + count));
                        count = 0;
                    }
                }

                if ((i == a.length() - 1 || j == b.length() - 1) && count > 0) {
                    String commonNew = a.substring(i, i + count);
                    if (!commons.contains(commonNew))
                        commons.add(a.substring(i, i + count));
                    count = 0;
                }
            }
        }
        return commons;
    }

    public static void main (String[] args) {
        String [] strings = {"abcdefg", "abc", "a"};
        System.out.println(new L14().longestCommonPrefix(strings));
    }
}
