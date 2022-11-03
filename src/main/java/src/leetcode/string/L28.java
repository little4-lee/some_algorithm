package leetcode.string;

/**
 * 28 Implement strStr()
 * https://leetcode.com/problems/implement-strstr/
 *
 * Implement strStr().
 *
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 *
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 *
 * For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
 *
 */
public class L28 {

    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null) return -1;
        if ("".equals(needle)) return 0;

        int index = -1;
        boolean match = false;
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            for (int j = 0; j < needle.length(); j++) {
                if (needle.charAt(j) == haystack.charAt(i + j)) {
                    if (j == needle.length() - 1) {
                        index = i;
                        match = true;
                        break;
                    }
                } else break;
            }
            if (match) break;
        }
        return index;
    }

    public static void main(String[] args) {
//        System.out.println(new L28().strStr("12345678", "5678"));
//        System.out.println(new L28().strStr("hello", "l"));
        System.out.println(new L28().strStr("", ""));
        System.out.println(new L28().strStr("1", "1"));
        System.out.println("".length());
    }
}
