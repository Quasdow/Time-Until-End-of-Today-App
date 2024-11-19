import java.time.Duration;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class CountdownTimer {

    public static String getTimeLeft() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime endOfDay = now.toLocalDate().atTime(LocalTime.MIDNIGHT);

        if (now.isAfter(endOfDay)) {
            endOfDay = endOfDay.plusDays(1);
        }

        Duration duration = Duration.between(now, endOfDay);
        long hours = duration.toHours();
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;

        return String.format("%02d : %02d : %02d", hours, minutes, seconds);
    }
}