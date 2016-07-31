import java.util.Scanner;

public class ex05_IntegerToHexAndBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long num = sc.nextLong();
        String hex = Long.toHexString(num).toUpperCase();
        String bin = Long.toBinaryString(num);
        System.out.println(hex);
        System.out.println(bin);
    }
}
