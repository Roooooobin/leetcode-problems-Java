import java.time.LocalDate;

public class Leetcode1185 {

    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        String[] weekday = {
            null, "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"
        };
        return weekday[localDate.getDayOfWeek().getValue()];
    }
}
