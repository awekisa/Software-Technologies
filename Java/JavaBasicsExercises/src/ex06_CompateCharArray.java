import java.util.Arrays;
import java.util.Scanner;

public class ex06_CompateCharArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr1 = sc.nextLine().split(" ");
        String[] arr2 = sc.nextLine().split(" ");
        int len = Math.min(arr1.length, arr2.length);
        boolean commonPart = true;
        if (Arrays.equals(arr1, arr2)) {
            printArr(arr1);
            System.out.println();
            printArr(arr2);
            commonPart = false;
        } else {
            for (int i = 0; i < len; i++) {
                char a = Character.toLowerCase(arr1[i].charAt(0));
                char b = Character.toLowerCase(arr2[i].charAt(0));
                if (a < b) {
                    printArr(arr1);
                    System.out.println();
                    printArr(arr2);
                    commonPart = false;
                    break;
                }
                else if (b < a){
                    printArr(arr2);
                    System.out.println();
                    printArr(arr1);
                    commonPart = false;
                    break;
                }
            }
        }
        if (commonPart){
            if (arr1.length <= arr2.length){
                printArr(arr1);
                System.out.println();
                printArr(arr2);
            }
            else{
                printArr(arr2);
                System.out.println();
                printArr(arr1);
            }
        }
    }

    private static void printArr(String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
}
