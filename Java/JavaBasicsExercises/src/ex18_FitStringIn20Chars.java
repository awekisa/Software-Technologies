
import java.util.Scanner;

public class ex18_FitStringIn20Chars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        if (str.length() < 20){
            sb.append(str);
            String temp = sb.toString();
            while(temp.length() != 20){
                sb.append("*");
                temp = sb.toString();
            }
            str = sb.toString();
        }
        else{
            str = str.substring(0, 20);
        }
        System.out.println(str);
    }
}

