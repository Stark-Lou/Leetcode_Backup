package contest.pinduoduo;


import java.util.Scanner;

public class Main7 {
    public static void main(String[] args) {
        System.out.println("请输入名字：");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        System.out.println("请输入年龄：");
        int age = sc.nextInt();
        System.out.println("姓名：" + name);
        System.out.println("年龄：" + age);
    }
}