import java.util.Arrays;
import java.util.Scanner;

public class ex09_MostFrequentNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
        int num = arr[0];
        int numCount = 0;
        int tempNum;
        int tempNumCount = 0;
        for (int i = 0; i < arr.length; i++) {
            tempNum = arr[i];
            tempNumCount = 0;
            for (int j = 0; j < arr.length; j++) {
                int a = arr[j];
                if (tempNum == a) {
                    tempNumCount++;
                }
            }
            if (tempNumCount > numCount) {
                num = tempNum;
                numCount = tempNumCount;
            }
        }
        System.out.println(num);
    }
}