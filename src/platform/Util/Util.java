package platform.Util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Util {
    public static String getDate() {
        LocalDateTime dateTime = LocalDateTime.now();
        return dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
}
