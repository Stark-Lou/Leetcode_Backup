package contest.test;

public interface Logger {
    public static SingleTon singleTon = SingleTon.getInstance();

    public void printSingleTon();

    public default void dosomething() {

    }
}
