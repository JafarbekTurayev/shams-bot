package ai.ecma.apppdpfoodbot.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils {

    public static String getTimeFromTimeStamp(Timestamp timestamp){
        return timestamp.getHours() + " : " + timestamp.getMinutes() + " : " + timestamp.getSeconds();
    }

    public static String getDateWithFormat(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        return formatter.format(date);
    }

}
