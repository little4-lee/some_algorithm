package leetcode.string;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 14Ex is from a mistake; not a problem form LeetCode.com;
 * cause I misunderstand the L14(Longest Common Prefix) to Longest Common String
 * However, this problem is interesting and worth thinking
 */
public class L14Ex {

    public String longestCommonStr (String[] strs) {
        if (strs == null) return null;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];


        //找到前两个字符串的共同子串
        List<String> commons = getCommonStr(strs[0], strs[1]);

        for (int i = 2; i < strs.length; i++) {
            for (String c : commons) {
                List<String> sub = getCommonStr(strs[i], c);
                if (sub.contains(c)) continue;
                else {
                    commons.remove(c);
                    for (String cc : sub) {
                        addIfNotExist(commons, cc);
                    }
                }
            }
        }


        int longestIndex = 0;
        for (int i = 1; i < commons.size(); i++) {
            if (commons.get(i).length() > commons.get(longestIndex).length()) longestIndex = i;
        }
        return commons.get(longestIndex);
    }

    public List<String> getCommonStr (String a, String b) {
        if (a == null || b == null) return null;

        List<String> commons = new ArrayList<String>();

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int cur = 1;
                    //求本次重合的公共字符串
                    while (true) {
                        if (i + cur < a.length() && j + cur < b.length()) {
                            if (a.charAt(i + cur) == b.charAt(j + cur)) cur++;
                            else break;
                        } else break;
                    }
                    String temp = a.substring(i, i + cur);
                    addIfNotExist(commons, temp);
                }
            }
        }
        return commons;
    }

    private void addIfNotExist (List<String> commons, String temp) {
        if (commons.contains(temp)) return;

        boolean exist = false;
        for (String c : commons) {
            if (c.contains(temp)) {
                exist = true;
                break;
            }
        }
        if (!exist) {
            //remove subString
            //避免重复计算，去掉temp的所有子字符串
            Iterator<String> iterator = commons.iterator();
            while (iterator.hasNext()) {
                String c = iterator.next();
                if (temp.contains(c)) iterator.remove();
            }
            commons.add(temp);
        }
    }

    public static void main (String[] args) {
        String[] strings = {"abcdefg", "abcdefg", "abcdefg", "abcdefg", "abcdefg", "abcdefg", "abcdefg", "abcdefg"};
        //            System.out.println(new LongestCommonStr().getCommonStr("abcdg", "adddg"));
        //            System.out.println(new LongestCommonStr().getCommonStr("abcdefg", "abdefga;lhdflkiewhfahdf"));
        //            System.out.println(new LongestCommonStr().getCommonStr("abcde", "acccde"));
        System.out.println(new L14Ex().longestCommonStr(strings));
    }


}
