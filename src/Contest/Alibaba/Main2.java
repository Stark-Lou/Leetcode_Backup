package Contest.Alibaba;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by Lou on 2017/3/25.
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        if(line != null && !line.isEmpty()) {
            int res = resolve(line.trim());
            System.out.println(String.valueOf(res));
        }
    }

    // write your code here
    public static int resolve(String expr) {
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        String[] contents = expr.split(" ");
        for(String content:contents){
            if(isInteger(content)) {
                if(inputs.size()<16)
                    inputs.add(Integer.valueOf(content));
                else return -2;
            }
            else {
                switch (content){
                    case "+":{
                        if(inputs.size() < 2) return -1;
                        int num1 = inputs.remove(inputs.size()-1);
                        int num2 = inputs.remove(inputs.size()-1);
                        inputs.add(num1+num2);
                        break;
                    }
                    case "*":{
                        if(inputs.size() < 2) return -1;
                        int num1 = inputs.remove(inputs.size()-1);
                        int num2 = inputs.remove(inputs.size()-1);
                        inputs.add(num1*num2);
                        break;
                    }
                    case "^":{
                        if(inputs.size() < 1) return -1;
                        int idx = inputs.size() -1 ;
                        inputs.set(idx,inputs.get(idx)+1);
                        break;
                    }
                    default:{
                        System.out.println("Unexpected operation");
                        return -3;
                    }
                }
            }
        }
        return inputs.remove(inputs.size()-1);
    }

    public static boolean isInteger(String str){
        Pattern pattern = Pattern.compile("^[\\d]*$");
        return pattern.matcher(str).matches();
    }

}
