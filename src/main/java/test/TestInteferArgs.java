package test;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TestInteferArgs {
    public void test(String key, ListenerTest test) {

    }

    public void method(String key) {

    }

    public void a(String[] args) {
        TestInteferArgs testInteferArgs = new TestInteferArgs();
        testInteferArgs.test("key", this::method);
    }

    public static void main(String[] args) {
        String test = "123456789e";
        System.out.println(test.substring(0, test.indexOf("e")));
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMddHHmmss");
        StringBuilder sb = new StringBuilder();
        String append = dateFormat.format(System.currentTimeMillis());
        sb.append(test, 0, 20 - append.length());
        sb.append(append);
        System.out.println(sb.toString());
        System.out.println(dateFormat.format(System.currentTimeMillis()));
        ;
        System.out.println(Instant.ofEpochSecond(System.currentTimeMillis() / 1000));
    }
}
