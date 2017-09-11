package contest.pinduoduo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> result = new ArrayList<>();
        int[] packages = new int[6];

        while (sc.hasNext()) {
            String content = sc.nextLine();
            if (content.equals("0 0 0 0 0 0")) {
                break;
            }
            String[] count = content.split(" ");
            if (count.length != 6) {
                System.out.println("Error");
            }
            for (int i = 0; i < count.length; i++) {
                packages[i] = Integer.valueOf(count[i]);
            }
            int packageCount = 0;
            int remainSize = 0;             //标记剩余的1*1空间数量
            packageCount += packages[5];    //6*6 直接占用一个箱子
            packageCount += packages[4];    //5*5 开辟一个箱子
            remainSize += packages[4] * 11;
            packageCount += packages[3];    //4*4 开辟一个箱子
            packageCount += packages[2] / 4 + 1;    //3*3 开辟一个箱子
            packages[2] = packages[2] % 4;
            if (packages[1] / 5 > packages[3]) {     //2*2 优先放入 4*4开辟的箱子
                packages[1] -= packages[3] * 5;
            } else {
                remainSize += (packages[3] * 5 - packages[1]) * 4;
                packages[1] = 0;
            }
            if (packages[1] / 3 > packages[2]) {    //2*2 尝试放入 3*3开辟的箱子
                packages[1] -= packages[2] * 3;
                packageCount += packages[1] / 9 + 1;        //放不下继续开辟新的箱子
                remainSize += packages[2] * 7 + (packages[1] / 9 + 1) * 36 - packages[1] * 4;
            } else {
                remainSize += (packages[2] * 5 - packages[1]) * 4 + packages[2] * 7;
            }
            if (remainSize < packages[0]) {
                packages[0] -= remainSize;
                packageCount += packages[0] / 36 + 1;
            }
            result.add(packageCount);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
}