import java.util.Arrays;
import java.util.Scanner;

public class ex08_MaxSequenceOfIncreasingElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
        int count = 1;
        int tempCount = 1;
        int startPos = 0;
        int tempPos = 0;
        boolean inSequence = false;
        for (int i = 0; i < arr.length - 1; i++) {
            int a = arr[i];
            int b = arr[i + 1];
            if (a < b) {
                if (inSequence) {
                    tempCount++;
                    if (i == arr.length - 1 - 1) {
                        if (tempCount > count) {
                            count = tempCount;
                            startPos = tempPos;
                        }
                    }
                } else {
                    inSequence = true;
                    tempCount++;
                    tempPos = i;
                }
            } else {
                if (tempCount > count) {
                    count = tempCount;
                    startPos = tempPos;
                }
                inSequence = false;
                tempCount = 1;
            }
        }
        if (tempCount > count) {
            count = tempCount;
            startPos = tempPos;
        }
        for (int i = startPos; i < count + startPos; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
