import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTime {
    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd HH:mm:ss";

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());
    }

    public static String mySQL() {
        return null;
    }

}
