import java.util.Scanner;

public class ex07_MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");
        int count = 0;
        int tempCount = 1;
        String longestElement = arr[0];
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i].equals(arr[i+1])){
                tempCount++;
                if (i == arr.length-1-1){
                    if (tempCount>count){
                        longestElement = arr[i];
                    }
                }
            }
            else{
                if (tempCount > count) {
                    count = tempCount;
                    tempCount = 1;
                    longestElement = arr[i];
                }
                else {
                    tempCount = 1;
                }
            }
        }
        if (tempCount > count){
            count = tempCount;
        }
        for (int i = 0; i < count; i++) {
            System.out.print(longestElement + " ");
        }
    }
}
