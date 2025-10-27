import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class formatUtility {
    private final static Locale locale = new Locale("id", "ID");
    private final static NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    private final static DateTimeFormatter dateTimeFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");


    public static String toRupiah(double value){
        return numberFormat.format(value);
    }

    public static String toFormattedDate(LocalDateTime localDateTime){
        return localDateTime.format(dateTimeFormat);
    }

    public static LocalDateTime parseFormattedDate(String stringOfDateTime){
        return LocalDateTime.parse(stringOfDateTime, dateTimeFormat);
    }

    public static String sanitizeKeyInput(String string){
        return string.replaceAll("\\s+", "").toLowerCase();
    }

}
