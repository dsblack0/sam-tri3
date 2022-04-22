package frqs;

import java.util.Arrays;

public class Q1_DiverseArray {

    public static int arraySum(int[] arr) {
        int sum = 0;
        for (int n : arr) {
            sum += n;
        }
        return sum;
    }

    public static int[] rowSums(int[][] arr2D) {
        int[] rowSum = new int[arr2D.length];
        int i = 0;
        for (int[] row : arr2D) {
            rowSum[i] = arraySum(row);
            i++;
        }
        return rowSum;
    }

    public static boolean isDiverse(int[][] arr2D) {
        int[] rowSums = rowSums(arr2D);
        for (int i = 0; i < rowSums.length; i++) {
            for (int j = i + 1; j < rowSums.length; j++) {
                if (rowSums[i] == rowSums[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = new int[] {1, 3, 2, 7, 3};
        System.out.println("Array Sum: " + arraySum(arr));

        int[][] arr2D = new int[][] {{1, 3, 2, 7, 3} , {10, 10, 4, 6, 2}, {5, 3, 5, 9, 6}, {7, 6, 4, 2, 1}};
        System.out.println("Row Sums: " + Arrays.toString(rowSums(arr2D)));
        System.out.println("Is Diverse: " + isDiverse(arr2D));
    }
}