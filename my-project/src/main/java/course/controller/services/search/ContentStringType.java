package course.controller.services.search;

import java.io.UnsupportedEncodingException;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.type.StringType;

public class ContentStringType extends StringType {

    private static final long serialVersionUID = -779216076922718133L;

    public Object get(ResultSet rs, String name) throws SQLException {
        String content = null;
        try {
            content = new String(rs.getBytes(name), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return content;
    }
}
