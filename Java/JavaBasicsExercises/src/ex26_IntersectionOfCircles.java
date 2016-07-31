import java.util.Arrays;
import java.util.Scanner;



public class ex26_IntersectionOfCircles {

    public static class Circle {
        double X;
        double Y;
        double radius;

        public double getX() {
            return X;
        }

        public void setX(double x) {
            X = x;
        }

        public double getY() {
            return Y;
        }

        public void setY(double y) {
            Y = y;
        }

        public double getRadius() {
            return radius;
        }

        public void setRadius(double radius) {
            this.radius = radius;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] first = Arrays.asList(sc.nextLine().split(" ")).stream().mapToDouble(Double::parseDouble).toArray();
        double[] second = Arrays.asList(sc.nextLine().split(" ")).stream().mapToDouble(Double::parseDouble).toArray();

        Circle firstCircle = new Circle();
        Circle secondCircle = new Circle();

        firstCircle.setX(first[0]);
        firstCircle.setY(first[1]);
        firstCircle.setRadius(first[2]);
        secondCircle.setX(second[0]);
        secondCircle.setY(second[1]);
        secondCircle.setRadius(second[2]);

        double distanceBetweenCenters = Math.sqrt(Math.pow((secondCircle.getX() - firstCircle.getX()), 2) + Math.pow((secondCircle.getY() - firstCircle.getY()), 2));
        if (distanceBetweenCenters <= firstCircle.getRadius() + secondCircle.getRadius()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}


