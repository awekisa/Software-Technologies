
import java.util.*;

public class ex17_ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        // First way
//        char[] arr = str.toCharArray();
//        List<Character> list = new ArrayList<Character>();
//        for (char c : arr
//                ) {
//            list.add(c);
//        }
//        Collections.reverse(list);
//        for (char c :list) {
//            System.out.print(c);
//        }
        // Second way
        char[] arr = str.toCharArray();
        for (int i = arr.length-1; i >= 0 ; i--) {
            System.out.print(arr[i]);
        }

    }
}
