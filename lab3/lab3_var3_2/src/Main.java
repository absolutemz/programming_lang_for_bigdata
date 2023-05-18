import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

class Year {
    private Month month;
    private Day day;

    public Year(Month month, Day day) {
        this.month = month;
        this.day = day;
    }

    public void setDate(int year, int month, int day) {
        this.month.setMonth(month);
        this.day.setDay(day);
    }

    public DayOfWeek getDayOfWeek() {
        LocalDate date = LocalDate.of(LocalDate.now().getYear(), this.month.getMonth(), this.day.getDay());
        return date.getDayOfWeek();
    }

    public long calculateDaysDifference(Year otherYear) {
        LocalDate thisDate = LocalDate.of(LocalDate.now().getYear(), this.month.getMonth(), this.day.getDay());
        LocalDate otherDate = LocalDate.of(LocalDate.now().getYear(), otherYear.month.getMonth(), otherYear.day.getDay());
        return Math.abs(ChronoUnit.DAYS.between(thisDate, otherDate));
    }

    public long calculateMonthsDifference(Year otherYear) {
        LocalDate thisDate = LocalDate.of(LocalDate.now().getYear(), this.month.getMonth(), this.day.getDay());
        LocalDate otherDate = LocalDate.of(LocalDate.now().getYear(), otherYear.month.getMonth(), otherYear.day.getDay());
        return Math.abs(ChronoUnit.MONTHS.between(thisDate, otherDate));
    }

    @Override
    public String toString() {
        return "Year{" +
                "month=" + month +
                ", day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Year year = (Year) o;
        return month.equals(year.month) && day.equals(year.day);
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day);
    }
}

class Month {
    private int month;

    public void setMonth(int month) {
        this.month = month;
    }

    public int getMonth() {
        return month;
    }

    @Override
    public String toString() {
        return "Month{" +
                "month=" + month +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Month month1 = (Month) o;
        return month == month1.month;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month);
    }
}

class Day {
    private int day;

    public void setDay(int day) {
        this.day = day;
    }

    public int getDay() {
        return day;
    }

    @Override
    public String toString() {
        return "Day{" +
                "day=" + day +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Day day1 = (Day) o;
        return day == day1.day;
    }

    @Override
    public int hashCode() {
        return Objects.hash(day);
    }
}

public class Main {
    public static void main(String[] args) {
        Month month = new Month();
        month.setMonth(5);

        Day day = new Day();
        day.setDay(18);

        Year currentYear = new Year(month, day);

        currentYear.setDate(LocalDate.now().getYear(), 5, 18);

        System.out.println("Day of the week: " + currentYear.getDayOfWeek());

        Year otherYear = new Year(new Month(), new Day());
        otherYear.setDate(2024, 5, 18);

        long daysDifference = currentYear.calculateDaysDifference(otherYear);
        System.out.println("Days difference: " + daysDifference);

        long monthsDifference = currentYear.calculateMonthsDifference(otherYear);
        System.out.println("Months difference: " + monthsDifference);
    }
}