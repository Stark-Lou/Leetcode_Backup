package Contest.Alibaba;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        int threadCount = Thread.activeCount();
        Thread.currentThread().getThreadGroup().activeCount();
        Thread currentThread = Thread.currentThread();
        System.out.println(threadCount);
        System.out.println(currentThread.getName());
    }
    private static void outputValue(double maxArea) {
        String valueStr = String.valueOf(maxArea);
        int idx = valueStr.indexOf(".");
        DecimalFormat df = new DecimalFormat("#.00000");
        if(idx >0 && valueStr.length()>idx +5) {
            String carry = "" + valueStr.charAt(idx + 6);
            if(Integer.valueOf(carry) >= 5)
                maxArea += 0.000001;
            System.out.println(df.format(maxArea));
        }else
            System.out.println(df.format(maxArea));
    }


}
