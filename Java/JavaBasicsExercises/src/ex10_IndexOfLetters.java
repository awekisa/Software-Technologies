import java.util.Scanner;

public class ex10_IndexOfLetters {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] arr = sc.nextLine().toCharArray();
        for (char ch : arr) {
            System.out.println(ch +" -> " + (ch - 97));
        }
    }
}
