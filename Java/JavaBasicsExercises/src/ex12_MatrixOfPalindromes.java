import java.util.Scanner;

public class ex12_MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
               char a = (char)(97 + r);
                char b = (char)(97 + r + c);
                System.out.printf("%c%c%c ", a, b, a);
            }
            System.out.println();
        }
    }
}
