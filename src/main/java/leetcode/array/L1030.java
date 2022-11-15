package leetcode.array;

/**
 * 1030. Matrix Cells in Distance Order
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 *
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 *
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 *
 * Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
 *
 *
 *
 * Example 1:
 *
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 */
public class L1030 {
    public int[][] allCellsDistOrder (int R, int C, int r0, int c0) {
        if (R == 0 || C == 0) return null;
        int[][] array = new int[R * C][2];
        //init data
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                array[i * C + j][0] = i;
                array[i * C + j][1] = j;
            }
        }
        //insert sort
        int cur, valToInsert, valCur;
        int[] temp;
        //from second element
        for (int toInsert = 1; toInsert < R * C; toInsert++) {
            cur = 0;
            valToInsert = Math.abs(array[toInsert][0] - r0) + Math.abs(array[toInsert][1] - c0);
            //insert to sorted array
            while (cur < toInsert) {
                valCur = Math.abs(array[cur][0] - r0) + Math.abs(array[cur][1] - c0);
                if (valToInsert < valCur) {
                    temp = array[toInsert];
                    for (int i = toInsert; i > cur; i--) {
                        //move element
                        array[i] = array[i - 1];
                    }
                    array[cur] = temp;
                    break;
                } else {
                    cur++;
                }
            }
        }

        return array;
    }

    public static void main (String[] args) {
        new L1030().allCellsDistOrder(2, 3, 1, 2);
    }

}
