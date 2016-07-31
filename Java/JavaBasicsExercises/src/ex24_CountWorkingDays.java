import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class ex24_CountWorkingDays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String firstLine = sc.nextLine();
        String secondLine = sc.nextLine();
        long workingDays = 0;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate firstDate = LocalDate.parse(firstLine, formatter);
        LocalDate secondDate = LocalDate.parse(secondLine, formatter);

        int days = firstDate.until(secondDate).getDays();

        for (int i = 0; i <= days; i++) {
            boolean workday = checkIfHoliday(firstDate);
            if (!workday) {
                workingDays++;
            }
            firstDate = firstDate.plusDays(1);
        }
        System.out.println(workingDays);
    }

    private static boolean checkIfHoliday(LocalDate date) {
        int month = date.getMonth().getValue();
        int day = date.getDayOfMonth();
        int weekDay = date.getDayOfWeek().getValue();

        boolean e1 = date.getDayOfMonth() == 1 && date.getMonth().getValue() == 1;
        boolean e2 = date.getDayOfMonth() == 3 && date.getMonth().getValue() == 3;
        boolean e3 = date.getDayOfMonth() == 1 && date.getMonth().getValue() == 5;
        boolean e4 = date.getDayOfMonth() == 6 && date.getMonth().getValue() == 5;
        boolean e5 = date.getDayOfMonth() == 24 && date.getMonth().getValue() == 5;
        boolean e6 = date.getDayOfMonth() == 6 && date.getMonth().getValue() == 9;
        boolean e7 = date.getDayOfMonth() == 22 && date.getMonth().getValue() == 9;
        boolean e8 = date.getDayOfMonth() == 1 && date.getMonth().getValue() == 11;
        boolean e9 = date.getDayOfMonth() == 24 && date.getMonth().getValue() == 12;
        boolean e10 = date.getDayOfMonth() == 25 && date.getMonth().getValue() == 12;
        boolean e11 = date.getDayOfMonth() == 26 && date.getMonth().getValue() == 12;
        boolean e12 = date.getDayOfWeek().getValue() == 6;
        boolean e13 = date.getDayOfWeek().getValue() == 7;


        if ((date.getDayOfMonth() == 1 && date.getMonth().getValue() == 1) ||
                (date.getDayOfMonth() == 3 && date.getMonth().getValue() == 3) ||
                (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 5) ||
                (date.getDayOfMonth() == 6 && date.getMonth().getValue() == 9) ||
                (date.getDayOfMonth() == 22 && date.getMonth().getValue() == 9) ||
                (date.getDayOfMonth() == 1 && date.getMonth().getValue() == 11) ||
                (date.getDayOfMonth() == 24 && date.getMonth().getValue() == 12) ||
                (date.getDayOfMonth() == 25 && date.getMonth().getValue() == 12) ||
                (date.getDayOfMonth() == 26 && date.getMonth().getValue() == 12)
                ) {
            return true;
        } else if (
                (date.getDayOfWeek().getValue() == 6) ||
                        (date.getDayOfWeek().getValue() == 7)
                ) {
            return true;
        }
        return false;
    }
}


