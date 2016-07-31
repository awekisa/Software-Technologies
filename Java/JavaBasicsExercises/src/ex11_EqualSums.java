import java.util.Arrays;
import java.util.Scanner;

public class ex11_EqualSums {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
        int leftSum = 0;
        int rightSum = 0;
        int equal = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < arr.length; i++) {
            for (int l = 0; l < i; l++) {
                leftSum += arr[l];
            }
            for (int r = i+1; r < arr.length; r++) {
                rightSum += arr[r];
            }
            if (leftSum == rightSum){
                found = true;
                equal = i;
            }
            leftSum = 0;
            rightSum = 0;
        }
        if (found){
            System.out.println(equal);
        }
        else{
            System.out.println("no");
        }
    }
}
