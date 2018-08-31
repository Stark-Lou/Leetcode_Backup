package contest.test;

public class SingleTon {
    private static SingleTon singleTon = new SingleTon();
    public static int count1;
    public static int count2 = 0;

    public SingleTon() {
        count1++;
        count2++;
        System.out.println("SingleTon Contractor");
    }

    public static SingleTon getInstance() {
        return singleTon;
    }

    @Override
    public String toString() {
        return "SingleTon{}";
    }

    public static void main(String[] args) {
        String content = "\"";
        System.out.println(content.replaceAll("\\(\\(", ""));

        SingleTon singleTon = SingleTon.getInstance();
        System.out.println("count1=" + singleTon.count1);
        System.out.println("count2=" + singleTon.count2);
    }
}