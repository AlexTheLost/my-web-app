package domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class TestDateValid {
    public static void main(String[] args) {
        SimpleDateFormat textDateBrithday = new SimpleDateFormat("yyyy-MM-dd");
        textDateBrithday.setLenient(false);
        try {
            textDateBrithday.parse("2013-12-31");
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
