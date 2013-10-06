package course.data.entity;

//import java.sql.Date;
import java.util.Date;
import java.text.SimpleDateFormat;

public class Test {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        System.out.println(sqlDate);
    }

}
