package java8_features;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

public class LocalDateTimeExample {
    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        System.out.println(currentTime);

        LocalDate date = LocalDate.now();
        date = currentTime.toLocalDate();
        System.out.println(date);

        Month month = date.getMonth();
        int dayMonth = date.getDayOfMonth();
        DayOfWeek day = date.getDayOfWeek();
        int seconds = currentTime.getSecond();

        System.out.printf("%s %d %s %d", month, dayMonth, day, seconds);
        System.out.println();

        ZonedDateTime zonedDateTime = ZonedDateTime.parse("2007-12-03T10:15:30+03:00[Asia/Baghdad]");
        System.out.println(zonedDateTime);

        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);

        LocalDate aWeekLater = date.plus(1, ChronoUnit.WEEKS);
        System.out.println(aWeekLater);

        Period period = Period.between(date, aWeekLater);
        System.out.println(period);

        Duration duration = Duration.between(currentTime, currentTime.plus(60,ChronoUnit.SECONDS));
        System.out.println(duration);

        LocalDate nextWednesday = LocalDate.now().with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        System.out.println(nextWednesday);

        LocalDate firstYear = LocalDate.of(date.getYear(), date.getMonth(), 1);
        LocalDate secondSat = firstYear.with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY))
                .with(TemporalAdjusters.nextOrSame(DayOfWeek.SATURDAY));
        System.out.println(secondSat);

        Date date1 = new Date();
        System.out.println(date1);

        Instant instant = date1.toInstant();

        LocalDateTime newDate = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println(newDate);
    }
}
