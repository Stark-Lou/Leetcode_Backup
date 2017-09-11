package contest.sogou;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String content = br.readLine();
            int n = Integer.valueOf(content);
            HashMap<Integer, List<Double>> map = new HashMap<>();

            for (int i = 0; i < n; i++) {
                String s = br.readLine();
                double val = Double.valueOf(s);
                if (val > 360) {
                    val %= 360;
                }
                ArrayList<Double> partList = new ArrayList<>();
                partList.add(val);
                map.put((int) val, partList);
            }
            int[] maxDisPart = new int[360];
            for (int i = 0; i < 180; i++) {
                int maxDis = 0;
                int dis;
                if (map.get(i) != null) {
                    for (int j = 0; j < 360; j++) {
                        if (map.get(j) != null) {
                            dis = Math.abs(i - j) % 180;
                            maxDis = dis > maxDis ? dis : maxDis;
                        }
                    }
                }
                maxDisPart[i] = maxDis;
            }
            int maxDisVal = 0;
            for (int aMaxDisPart : maxDisPart) {
                maxDisVal = aMaxDisPart > maxDisVal ? aMaxDisPart : maxDisVal;
            }
            List<Integer> maxParts = new ArrayList<>();
            for (int i = 0; i < maxDisPart.length; i++) {
                if (maxDisPart[i] == maxDisVal) {
                    maxParts.add(i);
                }
            }
            double maxDistant = 0;
            for (Integer i : maxParts) {
                List<Double> list1 = map.get(i);
                List<Double> list2 = map.get((i + maxDisVal) % 360);
                for (Double d1 : list1) {
                    for (Double d2 : list2) {
                        double dis = Math.abs(d2 - d1);
                        if (dis > maxDistant) {
                            maxDistant = dis;
                        }
                    }
                }
            }

            DecimalFormat df = new DecimalFormat("#.00000000");
            System.out.println(df.format(maxDistant));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
