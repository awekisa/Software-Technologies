import java.util.Scanner;

public class ex03_ReverseCharacters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String[] arr = new String[3];
        for (int i = 0; i < 3; i++) {
            str = sc.nextLine();
            arr[i] = str;
        }
        for (int i = 2; i >= 0 ; i--) {
            System.out.print(arr[i]);
        }
    }
}
