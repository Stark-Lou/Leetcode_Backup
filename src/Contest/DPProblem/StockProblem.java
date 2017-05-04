package Contest.DPProblem;

import java.util.Scanner;

/**
 * @描述： ${DESCRIPTION}
 * @创建者： Louzhoucheng
 * @日期： 2017-04-16 22:49
 * @修改者： Louzhoucheng
 * @修改日期： 2017-04-16 22:49
 * @版本： v1.0
 */
public class StockProblem {
    public static void main(String[] ags){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int idx = 1;
        int stockPrice = 1;
        int i=2;
        for(;idx+i<=n;i++){
            idx+=i;
            stockPrice += (i-2);
        }
        if(idx==n){
            System.out.println(stockPrice);
            return;
        }else {
            stockPrice+=(n-idx);
            System.out.println(stockPrice);
        }
    }
}
