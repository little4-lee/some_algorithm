package leetcode.array;

import java.util.Arrays;

/**
 * Intersection of Two Arrays
 * https://leetcode.com/problems/intersection-of-two-arrays/
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 * <p>
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class L349 {
    public int[] intersection (int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null) return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int p1 = 0, p2 = 0, intersectionLength = 0;
        while (p1 < nums1.length && p2 < nums2.length) {
            //duplicate in nums1
            if (p1 > 0 && nums1[p1] == nums1[p1 - 1]) {
                p1++;
                continue;
            }

            //duplicate in nums2
            if (p2 > 0 && nums2[p2] == nums2[p2 - 1]) {
                p2++;
                continue;
            }

            if (nums1[p1] == nums2[p2]) {
                nums2[intersectionLength++] = nums2[p2];
                p1++;
                p2++;
            } else {
                if (nums1[p1] < nums2[p2]) {
                    p1++;
                } else {
                    p2++;
                }
            }
        }

        return Arrays.copyOf(nums2, intersectionLength);
    }

    public static void main (String[] args) {
        int[] nums1 = {1,2,3,4,5,6,7};
        int[] nums2 = {1,1,1,1,8,7,6,5};

        for (int a : new L349().intersection(nums1, nums2)) {
            System.out.println(a);
        }
    }
}
