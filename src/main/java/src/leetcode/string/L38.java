package leetcode.string;

/**
 * 38. Count and Say
 * https://leetcode.com/problems/count-and-say/
 *
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 *
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 *
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 *
 * Note: Each term of the sequence of integers will be represented as a string.
 */
public class L38 {
    public String countAndSay (int n) {
        if (n == 1) return "1";

        String current = "1";
        StringBuilder builder = new StringBuilder();
        //记录一个重复出现的字符
        char curChar = 't';
        //上面字符出现的次数
        int count = 0;

        //从第二位开始
        for (int i = 2; i <= n; i++) {
            //清空之前的数据
            builder.delete(0, builder.length());
            for (int j = 0; j < current.length(); j++) {
                if (j == 0) {
                    curChar = current.charAt(j);
                    count = 1;
                } else {
                    if (curChar == current.charAt(j)) {
                        count++;
                    } else {//与之前字符不相同
                        builder.append("" + count + curChar);
                        curChar = current.charAt(j);
                        count = 1;
                    }
                }
                //最后一个元素
                if (j == current.length() - 1) {
                    builder.append("" + count + curChar);
                }
            }
            current = builder.toString();
        }
        return current;
    }

    public static void main (String[] args) {
        System.out.println(new L38().countAndSay(1));
        System.out.println(new L38().countAndSay(2));
        System.out.println(new L38().countAndSay(3));
        System.out.println(new L38().countAndSay(4));
        System.out.println(new L38().countAndSay(5));
        System.out.println(new L38().countAndSay(6));
        System.out.println(new L38().countAndSay(7));
        System.out.println(new L38().countAndSay(8));
        System.out.println(new L38().countAndSay(9));
        System.out.println(new L38().countAndSay(10));
        System.out.println(new L38().countAndSay(11));
        System.out.println(new L38().countAndSay(12));
        System.out.println(new L38().countAndSay(13));
        System.out.println(new L38().countAndSay(14));
        System.out.println(new L38().countAndSay(15));
        System.out.println(new L38().countAndSay(16));
        System.out.println(new L38().countAndSay(17));
        System.out.println(new L38().countAndSay(18));
        System.out.println(new L38().countAndSay(19));
        System.out.println(new L38().countAndSay(20));
    }
}
