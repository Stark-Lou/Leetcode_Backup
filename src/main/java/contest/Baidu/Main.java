package contest.Baidu;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Point[] points = new Point[n];
        ArrayList<Point> rList = new ArrayList<>();
        ArrayList<Point> gList = new ArrayList<>();
        ArrayList<Point> bList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String color = in.next();
            int x = in.nextInt();
            int y = in.nextInt();
            int z = in.nextInt();

            int[] pos = {x, y, z};
            points[i] = new Point(color, pos);
            switch (color) {
                case "R":
                    rList.add(points[i]);
                    break;
                case "G":
                    gList.add(points[i]);
                    break;
                case "B":
                    bList.add(points[i]);
                    break;
            }
        }
        if (rList.size() == 0) {
            double g = findMaxArea(gList);
            double b = findMaxArea(bList);
            outputValue(g > b ? g : b);
        } else if (gList.size() == 0) {
            double r = findMaxArea(rList);
            double b = findMaxArea(bList);
            outputValue(r > b ? r : b);
        } else if (bList.size() == 0) {
            double g = findMaxArea(gList);
            double r = findMaxArea(rList);
            outputValue(g > r ? g : r);
        } else {
            outputValue(findMaxArea(rList, gList, bList));
        }
    }

    private static double findMaxArea(ArrayList<Point> list) {
        double maxArea = 0d;
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++)
                for (int k = j + 1; k < n; k++) {
                    double area = area(list.get(i), list.get(j), list.get(k));
                    if (area > maxArea)
                        maxArea = area;
                }
        }
        return maxArea;
    }

    private static double findMaxArea(ArrayList<Point> rlist, ArrayList<Point> glist, ArrayList<Point> blist) {
        double maxArea = 0f;
        for (int i = 0; i < rlist.size(); i++) {
            for (int j = i + 1; j < glist.size(); j++)
                for (int k = j + 1; k < blist.size(); k++) {
                    double area = area(rlist.get(i), glist.get(j), blist.get(k));
                    if (area > maxArea)
                        maxArea = area;
                }
        }
        return maxArea;
    }

    private static void outputValue(double maxArea) {
        BigDecimal b = new BigDecimal(maxArea);
        Double value = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        DecimalFormat df = new DecimalFormat("#.00000");
        System.out.println(df.format(value));

    }

    public static double dis(Point p1, Point p2) {
        float result = 0;
        for (int i = 0; i < 3; i++) {
            result += Math.pow((p1.pos[i] - p2.pos[i]), 2);
        }
        return Math.sqrt(result);
    }

    public static double area(Point p1, Point p2, Point p3) {
        double a = dis(p1, p2);
        double b = dis(p1, p3);
        double c = dis(p2, p3);
        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }

    static class Point {
        String color;
        int[] pos;

        public Point(String color, int[] pos) {
            this.color = color;
            this.pos = pos;
        }
    }
}
