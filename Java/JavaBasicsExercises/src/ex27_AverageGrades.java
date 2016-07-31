import java.util.*;

public class ex27_AverageGrades {
    public static class Student {
        public String name;
        public ArrayList<Double> grades;
        double averageGrade;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public ArrayList<Double> getGrades() {
            return grades;
        }

        public void setGrades(ArrayList<Double> grades) {
            this.grades = grades;
        }

        public double getAverageGrade() {
            return averageGrade;
        }

        public void setAverageGrade(double averageGrade) {
            this.averageGrade = averageGrade;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            String[] arr = sc.nextLine().split(" ");
            String name = arr[0];
            ArrayList<Double> grades = new ArrayList<>();
            for (int j = 1; j < arr.length; j++) {
                grades.add(Double.parseDouble(arr[j]));
            }
            double averageGrade = grades.stream().mapToDouble(a -> a).average().getAsDouble();
            Student student = new Student();
            student.setName(name);
            student.setGrades(grades);
            student.setAverageGrade(averageGrade);
            students.add(student);
        }

        students.stream()
                .filter(s -> s.getAverageGrade() >= 5)
                .sorted((g1, g2) -> Double.compare(g2.getAverageGrade(), g1.getAverageGrade()))
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(student -> {
                    System.out.printf("%s -> %.2f\n",student.getName(), student.getAverageGrade());
                });
    }
}
