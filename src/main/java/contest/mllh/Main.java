package contest.mllh;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Lou on 2017/8/31.
 */
public class Main {

    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String content;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy MM dd");
        while (sc.hasNext()) {
            content = sc.nextLine();
            Date date = simpleDateFormat.parse(content);
            Date dateS = simpleDateFormat.parse(content.substring(0, 4) + " 01 01");
            int days = (int) ((date.getTime() - dateS.getTime()) / (1000 * 3600 * 24)) + 1;
            System.out.println(days);
        }
    }
}

