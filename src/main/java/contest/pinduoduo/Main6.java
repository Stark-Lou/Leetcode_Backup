package contest.pinduoduo;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.valueOf(sc.nextLine());
        File[] files = new File[n];
        for (int i = 0; i < n; i++) {
            String content = sc.nextLine();
            String[] strings = content.split(" ");
            int fatherId = Integer.valueOf(strings[1]);
            files[i] = new File(strings[0], i, fatherId);
            if (fatherId != -1 && files[fatherId] != null) {
                files[fatherId].addChild(files[i]);
            } else {
                System.out.println("Error");
            }
        }
        files[0].print("");
    }

    public static class File {
        String name;
        int id;
        int fatherId;
        List<File> children;

        public File(String name, int id, int fatherId) {
            this.name = name;
            this.id = id;
            this.fatherId = fatherId;
        }

        public void addChild(File file) {
            if (children == null) {
                List<File> list = new ArrayList<>();
                list.add(file);
                children = list;
            } else {
                children.add(file);
            }
        }

        public void print(String pre) {
            if (children == null) {
                return;
            }
            StringBuilder result = new StringBuilder();
            result.append(pre);
            for (int i = 0; i < children.size(); i++) {
                if (i != children.size() - 1) {
                    result.append("|--");
                    result.append(name);
                    System.out.println(result.toString());
                    children.get(i).print(pre + "|  ");
                } else {
                    result.append("`--");
                    result.append(name);
                    System.out.println(result.toString());
                    children.get(i).print(pre + "   ");
                }

            }
        }
    }
}