package experements;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Slf4j
public class DateFormatTest {

    @Test
    public void testLocale(){
        Date d = new Date();

        Locale l = new Locale("en", "ru");
        log.info("Locale {}", l);
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        log.info("{}", df);

        log.info(df.format(d));
    }
}
