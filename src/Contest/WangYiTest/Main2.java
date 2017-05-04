package Contest.WangYiTest;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main2 implements Serializable{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p[] = new int[n];
        for(int i =0;i<n;i++){
            p[i] = in.nextInt();
        }
        Hashtable h = new Hashtable();
        HashMap hashMap = new HashMap();
        //找到可能错误的百分之四十的题
        int target = 4*n/10;
        while(target-->0){

        }
    }
}
