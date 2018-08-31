package contest.test;

public class LoggerImpl implements Logger {
    @Override
    public void printSingleTon() {
        System.out.println(Logger.singleTon);
    }
}
