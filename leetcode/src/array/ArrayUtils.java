package array;

public class ArrayUtils {
    public static void printArray (int[] array) {
        if (array == null) {
            System.out.println("empty array");
        } else {
            System.out.print("[");
            for (int i = 0; i < array.length; i++) {
                System.out.print(array[i]);
                if (i < array.length - 1) {
                    System.out.print(",");
                }
            } System.out.println("]");
        }
    }
}
