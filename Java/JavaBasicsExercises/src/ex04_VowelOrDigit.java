import java.util.Scanner;

public class ex04_VowelOrDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.next().charAt(0);
        if (Character.isDigit(ch)){
            System.out.println("digit");
        }
        else {
            switch (Character.toLowerCase(ch)) {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                case 'y':
                    System.out.println("vowel");
                    break;
                default:
                    System.out.println("other");
            }
        }
    }
}
