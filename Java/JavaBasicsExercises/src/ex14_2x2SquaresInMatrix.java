
import java.util.Scanner;

public class ex14_2x2SquaresInMatrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int count = 0;
        sc.nextLine();
        char[][] matrix = new char[rows][];
        for (int i = 0; i < rows; i++) {
            char[] arr = sc.nextLine().replaceAll(" ", "").toCharArray();
            matrix[i] = arr;
        }

        for (int r = 0; r < rows-1; r++) {
            for (int c = 0; c < cols-1; c++) {
                char upLeft = matrix[r][c];
                char downLeft = matrix[r+1][c];
                char upRight = matrix[r][c+1];
                char downRight = matrix[r+1][c+1];
                if (upLeft == downLeft && upRight == downRight && upLeft == upRight){
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
