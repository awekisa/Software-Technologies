import java.util.Scanner;

public class ex21_ChangeToUppercase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String firstTag = "<upcase>";
        String secondTag = "</upcase>";
        int firstIndex = text.indexOf(firstTag);
        int secondIndex = text.indexOf(secondTag);
        String subString;
        String toUpper;

        while(firstIndex > -1 && secondIndex > -1){
            int leftDelIndex = firstIndex + 8;
            int secondDelIndex = secondIndex + 9;
            subString = text.substring(leftDelIndex, secondIndex);
            toUpper = subString.toUpperCase();
            text = text.replaceFirst((firstTag + subString + secondTag), toUpper);
            firstIndex = text.indexOf(firstTag);
            secondIndex = text.indexOf(secondTag);
        }
        System.out.println(text);
    }
}
