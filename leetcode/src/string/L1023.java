package string;

import java.util.ArrayList;
import java.util.List;

/**
 * 1023. Camelcase Matching
 * https://leetcode.com/problems/camelcase-matching/
 *
 * A query word matches a given pattern if we can insert lowercase letters to the pattern word so that it equals the query. (We may insert each character at any position, and may insert 0 characters.)
 *
 * Given a list of queries, and a pattern, return an answer list of booleans, where answer[i] is true if and only if queries[i] matches the pattern.
 *
 * Example 1:
 *
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * Output: [true,false,true,true,false]
 * Explanation:
 * "FooBar" can be generated like this "F" + "oo" + "B" + "ar".
 * "FootBall" can be generated like this "F" + "oot" + "B" + "all".
 * "FrameBuffer" can be generated like this "F" + "rame" + "B" + "uffer".
 * Example 2:
 *
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * Output: [true,false,true,false,false]
 * Explanation:
 * "FooBar" can be generated like this "Fo" + "o" + "Ba" + "r".
 * "FootBall" can be generated like this "Fo" + "ot" + "Ba" + "ll".
 * Example 3:
 *
 * Input: queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * Output: [false,true,false,false,false]
 * Explanation:
 * "FooBarTest" can be generated like this "Fo" + "o" + "Ba" + "r" + "T" + "est".
 *
 * Note:
 *
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * All strings consists only of lower and upper case English letters.
 */
public class L1023 {

    /**
     * bad implement
     */
//    public List<Boolean> camelMatch(String[] queries, String pattern) {
//        if (queries == null || pattern == null) return null;
//        List<Boolean> results = new ArrayList<>();
//
//        //split pattern
//        List<String> patternArr = new ArrayList<>();
//        char temp;
//        int lastStartIndex = 0;
//        int length = pattern.length();
//        for (int i = 0; i < length; i++) {
//            temp = pattern.charAt(i);
//            if (temp <= 'Z') {
//                String str = pattern.substring(lastStartIndex, i);
//                if (str != null && str.length() > 0) {
//                    patternArr.add(str);
//                    lastStartIndex = i;
//                }
//            }
//            if (i == length - 1) {
//                patternArr.add(pattern.substring(lastStartIndex, length));
//            }
//        }
//
//        String query;
//        boolean flag;
//        int patternLength = pattern.length();
//
//        for (int i = 0; i< queries.length; i++) {
//            query = queries[i];
//            flag = true;
//
//            //query长度小于pattern，一定不匹配
//            if (query.length() < patternLength) {
//                results.add(i, false);
//                continue;
//            }
//
//            int queryIndex = 0;
//            for (int j = 0; j < patternArr.size(); j++) {
//                if (queryIndex >= query.length()) {
//                    flag = false;
//                    break;
//                }
//                if (!flag) break;
//                for (int k = 0; k < patternArr.get(j).length(); k++) {
//                    if (patternArr.get(j).charAt(k) == query.charAt(queryIndex)) {
//                        queryIndex++;
//                    } else {
//                        if (query.charAt(queryIndex) > 'Z') {
//                            k--;
//                            queryIndex++;
//                            if (queryIndex >= query.length()) {
//                                flag = false;
//                                break;
//                            }
//                        } else {
//                            if (k <= patternArr.get(j).length() - 1) {
//                                flag = false;
//                                break;
//                            }
//                        }
//                    }
//                }
//
//                while (queryIndex < query.length()) {
//                    if (query.charAt(queryIndex) > 'Z') queryIndex++;
//                    else break;
//                }
//
//                if (j == patternArr.size() - 1 && queryIndex <= query.length() - 1) flag = false;
//            }
//
//            results.add(i, flag);
//        }
//        return results;
//    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        if (queries == null || pattern == null) return null;
        List<Boolean> results = new ArrayList<>();

        boolean flag;
        String query;
        //主要逻辑是操作两个下标
        int queryIndex;
        int patternIndex;
        for (int i = 0; i < queries.length; i++) {
            query = queries[i];

            if (query.length() < pattern.length()) {
                results.add(i, false);
                continue;
            }

            flag = true;
            queryIndex = 0;
            patternIndex = 0;

            while (queryIndex < query.length() && patternIndex < pattern.length()) {
                if (query.charAt(queryIndex) == pattern.charAt(patternIndex)) {
                    queryIndex++;
                    patternIndex++;
                } else {
                    if (query.charAt(queryIndex) <= 'Z') {
                        flag = false;
                        break;
                    }
                    queryIndex++;
                }
            }


            if (patternIndex < pattern.length()) {
                flag = false;
            }

            if (queryIndex < query.length()) {
                while (queryIndex < query.length()) {
                    if (query.charAt(queryIndex) <= 'Z') {
                        flag = false;
                        break;
                    }
                    else queryIndex++;
                }
            }

            results.add(i, flag);
        }

        return results;
    }

    public static void main (String[] args) {
        String[] queries = {"BoBa", "BosBacod", "BobbbCaBa", "BoooBaaaaa", "BoooBaaaaaB", "BoBb", "BoBaaaaA"};
        String pattern = "BoBa";

//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String pattern = "FoBaT";

//        String[] queries = {"CompetitiveProgramming","CounterPick","ControlPanel"};
//        String pattern = "CooP";
        System.out.println(new L1023().camelMatch(queries, pattern));
    }
}
