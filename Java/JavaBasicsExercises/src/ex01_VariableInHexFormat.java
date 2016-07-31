import java.util.Scanner;

public class ex01_VariableInHexFormat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int result = Integer.valueOf(str, 16);
        System.out.println(result);
    }
}
