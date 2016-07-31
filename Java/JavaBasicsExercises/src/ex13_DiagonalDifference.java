import java.util.Arrays;
import java.util.Scanner;

public class ex13_DiagonalDifference {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        int[][] matrix = new int[num][];
        for (int i = 0; i < num; i++) {
            int[] arr = Arrays.asList(sc.nextLine().split(" ")).stream().mapToInt(Integer::parseInt).toArray();
            matrix[i] = arr;
        }

        int leftDiagonal = 0;
        int rightDiagonal = 0;

        for (int i = 0; i < num; i++) {
            leftDiagonal += matrix[i][i];
            rightDiagonal += matrix[num-1-i][i];
        }
        System.out.println(Math.abs(leftDiagonal - rightDiagonal));
    }
}
