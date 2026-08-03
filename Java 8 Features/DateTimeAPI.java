// Java 8 introduced a completely new Date and Time API in the java.time package (JSR-310).
// Why the new API?
// 1. Thread-safety: The older java.util.Date and SimpleDateFormat are NOT thread-safe, leading to concurrency issues. The new API classes are immutable.
// 2. Clear design: Separates human-readable dates (LocalDate) from times (LocalTime), timezone datetimes (ZonedDateTime), and machine timestamp (Instant).
// 3. Easier calculations: Methods like plusDays(), minusMonths(), etc., make calculations intuitive.

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.ZoneId;
import java.time.Period;
import java.time.Duration;
import java.time.format.DateTimeFormatter;

public class DateTimeAPI {
    public static void main(String[] args) {

        // ====================================================
        // PART 1: LocalDate (Represents just a Date - YYYY-MM-DD)
        // ====================================================
        System.out.println("=== Part 1: LocalDate ===");
        LocalDate today = LocalDate.now(); // Current system date
        System.out.println("Today's Date: " + today);

        LocalDate customDate = LocalDate.of(2026, 8, 15); // Specific date: Aug 15, 2026
        System.out.println("Custom Date: " + customDate);

        // Date calculations (returns new instances since they are immutable)
        LocalDate nextWeek = today.plusWeeks(1);
        LocalDate lastYear = today.minusYears(1);
        System.out.println("Date after 1 week: " + nextWeek);
        System.out.println("Date 1 year ago: " + lastYear);


        // ====================================================
        // PART 2: LocalTime (Represents just Time - HH:mm:ss.nanos)
        // ====================================================
        System.out.println("\n=== Part 2: LocalTime ===");
        LocalTime now = LocalTime.now(); // Current system time
        System.out.println("Current Time: " + now);

        LocalTime customTime = LocalTime.of(14, 30, 0); // 14:30:00 (2:30 PM)
        System.out.println("Custom Time: " + customTime);

        // Time calculations
        LocalTime inThreeHours = now.plusHours(3);
        System.out.println("Time in 3 hours: " + inThreeHours);


        // ====================================================
        // PART 3: LocalDateTime (Combines Date and Time)
        // ====================================================
        System.out.println("\n=== Part 3: LocalDateTime ===");
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("Current DateTime: " + currentDateTime);

        LocalDateTime specificDateTime = LocalDateTime.of(today, customTime);
        System.out.println("Specific DateTime combined: " + specificDateTime);


        // ====================================================
        // PART 4: ZonedDateTime (Handles Timezones)
        // ====================================================
        System.out.println("\n=== Part 4: ZonedDateTime ===");
        ZonedDateTime currentZonedDateTime = ZonedDateTime.now(); // Default system zone
        System.out.println("Current ZonedDateTime: " + currentZonedDateTime);

        // Get time in a specific timezone, e.g., America/New_York
        ZonedDateTime nyTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        System.out.println("Time in New York: " + nyTime);


        // ====================================================
        // PART 5: DateTimeFormatter (Formatting and Parsing)
        // ====================================================
        System.out.println("\n=== Part 5: Formatting and Parsing ===");
        LocalDateTime myDate = LocalDateTime.of(2026, 8, 3, 21, 30);
        
        // Define format pattern
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        
        // Formatting: Object -> String
        String formattedDate = myDate.format(formatter);
        System.out.println("Formatted Date String: " + formattedDate);

        // Parsing: String -> Object
        String dateString = "25-12-2026 00:00:00";
        LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);
        System.out.println("Parsed LocalDateTime: " + parsedDate);


        // ====================================================
        // PART 6: Period and Duration (Calculating differences)
        // ====================================================
        System.out.println("\n=== Part 6: Period vs Duration ===");

        // Period: Calculates the difference between two Dates in years, months, and days
        LocalDate startLocalDate = LocalDate.of(2020, 1, 1);
        LocalDate endLocalDate = LocalDate.of(2026, 8, 3);
        Period period = Period.between(startLocalDate, endLocalDate);
        System.out.println("Period difference: " + period.getYears() + " years, " 
                           + period.getMonths() + " months, " 
                           + period.getDays() + " days.");

        // Duration: Calculates the difference between two Times/Instants in hours, minutes, seconds, nanos
        LocalTime time1 = LocalTime.of(10, 0, 0);
        LocalTime time2 = LocalTime.of(15, 30, 45);
        Duration duration = Duration.between(time1, time2);
        System.out.println("Duration difference: " + duration.toHours() + " hours, " 
                           + (duration.toMinutes() % 60) + " minutes, " 
                           + (duration.toSeconds() % 60) + " seconds.");
    }
}
