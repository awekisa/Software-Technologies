import java.util.Scanner;

public class ex19_CensorEmailAdress {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String email = sc.nextLine();
        String text = sc.nextLine();
        String[] arr = email.split("@");
        String username = arr[0];
        String domain = arr[1];
        String replace = username.replaceAll("(?s).", "*");
        String censoredEmail =  replace + "@" + domain;

        text = text.replaceAll(email, censoredEmail);

        System.out.println(text);

    }
}
