import java.util.Scanner;

public class ex05_SymmetricNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            if (symmetricNum(i)){
                System.out.print(i + " ");
            }
        }
    }

    private static boolean symmetricNum(int i) {
        String num = i + "";
        for (int j = 0; j < num.length()/2; j++) {
            if (num.charAt(j) != num.charAt(num.length()-1-j)){
                return false;
            }
        }
        return true;
    }
}
