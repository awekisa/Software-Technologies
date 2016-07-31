import java.util.Scanner;

public class ex03_ThreeIntegersSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        if (!check(a, b, c) && !check(a, c, b) && !check(b, c, a)){
            System.out.println("No");
        }
    }

    private static boolean check(int a, int b, int c) {
        if (a + b != c){
            return false;
        }
        else if (a < b){
            System.out.printf("%d + %d = %d", a, b, c);
        }
        else{
            System.out.printf("%d + %d = %d", b, a, c);
        }
        return true;
    }
}
