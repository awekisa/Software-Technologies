import java.util.Scanner;

public class ex04_SumNIngegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long next = sc.nextLong();
            sum += next;
        }
        System.out.println(sum);
    }
}
