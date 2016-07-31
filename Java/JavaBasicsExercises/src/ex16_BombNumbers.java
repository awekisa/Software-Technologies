import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ex16_BombNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(" ");
        int[] arr = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
        List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int num = sc.nextInt();
        int power = sc.nextInt();

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == num){
                int leftIndex;
                int rightLenght;
                if (i - power < 0){
                    leftIndex = 0;
                }
                else{
                    leftIndex = i - power;
                }
                if (i + power> list.size()){
                    rightLenght = list.size();
                }
                else{
                    rightLenght = i + power;
                }
                list = bombList(list, leftIndex, rightLenght);
                i--;
            }
        }
        int sum = calculateSum(list);
        System.out.println(sum);
    }

    private static int calculateSum(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
           sum += list.get(i);
        }
        return sum;
    }

    private static List<Integer> bombList(List<Integer> list, int leftIndex, int rightLenght) {
        for (int i = 0; i <= rightLenght-leftIndex; i++) {
            if (list.size() == 0) {
                break;
            }
            list.remove(leftIndex);
        }
        return list;
    }
}
