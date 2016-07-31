import java.util.Scanner;

public class ex02_BooleanVariable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean bool = Boolean.parseBoolean(str);
        if (bool){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
    }
}
