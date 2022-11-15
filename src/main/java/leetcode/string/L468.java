package leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 468. Validate IP Address
 * https://leetcode.com/problems/validate-ip-address/
 * <p>
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 * <p>
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers, each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * <p>
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 * <p>
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits. The groups are separated by colons (":"). For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one. Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * <p>
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::) to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * <p>
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334 is invalid.
 * <p>
 * Note: You may assume there is no extra space or special characters in the input string.
 * <p>
 * Example 1:
 * Input: "172.16.254.1"
 * <p>
 * Output: "IPv4"
 * <p>
 * Explanation: This is a valid IPv4 address, return "IPv4".
 * Example 2:
 * Input: "2001:0db8:85a3:0:0:8A2E:0370:7334"
 * <p>
 * Output: "IPv6"
 * <p>
 * Explanation: This is a valid IPv6 address, return "IPv6".
 * Example 3:
 * Input: "256.256.256.256"
 * <p>
 * Output: "Neither"
 * <p>
 * Explanation: This is neither a IPv4 address nor a IPv6 address.
 */
public class L468 {
    public String validIPAddress (String IP) {
        if (IP == null || IP.length() < 7/*低于IPv4的最小长度*/ || IP.length() > 39/*高于IPv6的最大长度*/)
            return "Neither";

        List<String> subs = new ArrayList<String>();
        //pre condition of IPv4
        int dotCount = 0;
        ////pre condition of IPv6
        int colonCount = 0;
        //start index of substring
        int subIpStartIndex = 0;
        for (int i = 0; i < IP.length(); i++) {

            if (i == IP.length() - 1) {
                subs.add(IP.substring(subIpStartIndex, i + 1));
                break;
            }
            if (IP.charAt(i) == '.') {
                dotCount++;
                subs.add(IP.substring(subIpStartIndex, i));
                subIpStartIndex = i + 1;
                continue;
            }
            if (IP.charAt(i) == ':') {
                colonCount++;
                subs.add(IP.substring(subIpStartIndex, i));
                subIpStartIndex = i + 1;
            }
        }

        //check IPv4
        if (dotCount == 3 && subs.size() == 4) {
            boolean isIPV4 = true;
            for (String sub : subs) {
                //Integer.parseInt("-0") ==> 0, "-0" is not valid; "0" is valid;
                if (sub == null || "".equals(sub) || sub.startsWith("-")) {
                    isIPV4 = false;
                    break;
                }

                //leading zero
                if (sub.length() > 1 && sub.startsWith("0")) {
                    isIPV4 = false;
                    break;
                }

                if (!isValidNumber(sub, 10)) {
                    isIPV4 = false;
                    break;
                }

                int value = Integer.parseInt(sub);
                if (value < 0 || value > 255) {
                    isIPV4 = false;
                    break;
                }
            }
            if (isIPV4) return "IPv4";
        }

        //check IPv6
        if (colonCount == 7 && subs.size() == 8) {
            boolean isIPv6 = true;

            for (String sub : subs) {
                if (sub == null || "".equals(sub) || sub.length() > 4 || sub.startsWith("-")) {
                    isIPv6 = false;
                    break;
                }

                if (!isValidNumber(sub, 16)) {
                    isIPv6 = false;
                    break;
                }
            }

            if (isIPv6) return "IPv6";
        }

        return "Neither";
    }

    private boolean isValidNumber (String string, int radix) {
        try {
            Integer.parseInt(string, radix);
            return true;
        } catch (NumberFormatException | NullPointerException e) {
            return false;
        }
    }

    public static void main (String[] args) {
        System.out.println("1 " + new L468().validIPAddress("121.121.121.121"));
        System.out.println("2 " + new L468().validIPAddress("121.121.121.256"));
        System.out.println("3 " + new L468().validIPAddress("121.121.121.0"));
        System.out.println("4 " + new L468().validIPAddress("0.0.0.0"));
        System.out.println("5 " + new L468().validIPAddress("0.0.0.-0"));
        System.out.println("6 " + new L468().validIPAddress("121:121:121:121:121:121:121:0111"));
        System.out.println("7 " + new L468().validIPAddress("0:0:0:0:0:0:0:00111"));
        System.out.println("8 " + new L468().validIPAddress("2121:G121:121:121:121:121:121:0111"));
        System.out.println("9 " + new L468().validIPAddress("2121:A121:FF21:CC21:1DD1:1CC1:121:0111"));
        System.out.println("10 " + new L468().validIPAddress("121::121:121:121:121:121:0111"));
    }
}