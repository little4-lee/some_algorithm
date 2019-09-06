package array;

/**
 * 976. Largest Perimeter Triangle
 * https://leetcode.com/problems/largest-perimeter-triangle/
 * <p>
 * Given an array A of positive lengths, return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 * <p>
 * If it is impossible to form any triangle of non-zero area, return 0.
 */
public class L976 {
    public int largestPerimeter (int[] A) {
        if (A == null || A.length < 3) return 0;

        //selection sort
        int minIndex;
        int temp;
        for (int i = 0; i < A.length; i++) {
            minIndex = i;
            for (int j = i + 1; j < A.length; j++) {
                if (A[j] < A[minIndex]) minIndex = j;
            }
            if (i == minIndex) continue;
            temp = A[minIndex];
            A[minIndex] = A[i];
            A[i] = temp;
        }

        for (int i = A.length - 3; i >= 0; i--) {
            int perimeter = calculate(A[i], A[i + 1], A[i + 2]);
            if (perimeter != 0) return perimeter;
        }

        return 0;
    }

    /**
     * @param array
     * @return perimeter
     * if impossible to form any triangle, return 0
     */
    public int calculate (int... array) {
        if (array[0] + array[1] <= array[2]) return 0;

        return array[0] + array[1] + array[2];
    }

    public static void main (String[] args) {
        int[] array = {1, 2, 1};
        System.out.println(new L976().largestPerimeter(array));
    }
}
