import java.util.Scanner;

public class ex20_URLParser {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String firstDelimiter = "://";
        String secondDelimiter = "/";
        int indexFirst = str.indexOf(firstDelimiter);
        String protocol = "";
        String server = "";
        String resource = "";
        if (indexFirst > -1){
            protocol = str.substring(0, indexFirst);
            str = str.substring(indexFirst + 3, str.length());
        }

        int indexSecond = str.indexOf(secondDelimiter);
        if (indexSecond > -1){
            server = str.substring(0, indexSecond);
            str = str.substring(indexSecond+1, str.length());
            resource = str;
        }
        else{
            server = str;
        }



        System.out.printf("[protocol] = \"%s\"\n", protocol);
        System.out.printf("[server] = \"%s\"\n", server);
        System.out.printf("[resource] = \"%s\"\n", resource);

    }
}
