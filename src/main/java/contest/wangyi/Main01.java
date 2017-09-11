package contest.wangyi;


import java.util.*;
import java.util.function.BiConsumer;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        //形成数据字典
        Set<String> cenSet = new HashSet<>();
        Set<String> proSet = new HashSet<>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            cenSet.add(options[1]);
            cenSet.add(options[3]);
            proSet.add(options[2]);
            proSet.add(options[4]);
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList, cenSet, proSet);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList, Set<String> cenSet, Set<String> proSet) {
        List<String> result = new ArrayList<String>();

        lineList.sort(new Comparator<UnilateralLine>() {
            @Override
            public int compare(UnilateralLine o1, UnilateralLine o2) {
                return o1.sCen.compareTo(o2.sCen);
            }
        });
        //按出发分拨划分
        Map<String, List<UnilateralLine>> map = new HashMap<>();
        for (String cen : cenSet) {
            for (UnilateralLine line : lineList) {
                if (line.sCen.equals(cen)) {
                    if (map.get(cen) == null) {
                        ArrayList<UnilateralLine> list = new ArrayList<>();
                        list.add(line);
                        map.put(cen, list);
                    } else {
                        map.get(cen).add(line);
                    }
                }
            }

        }
        for (String key : map.keySet()) {
            List<UnilateralLine> unilateralLines = map.get(key);
            Iterator<UnilateralLine> itr = unilateralLines.iterator();
            while (itr.hasNext()) {
                List<UnilateralLine> list = map.get(itr.next().eCen);
                Iterator<UnilateralLine> listIt = list.iterator();
                while (listIt.hasNext()) {
                    if (listIt.next().eCen.equals(key) && listIt.next().tType.equals(itr.next().tType)) {
                        listIt.remove();
                        itr.remove();
                        result.add("rule1:" + itr.next().id + "+" + listIt.next().id);
                    }
                }
            }
        }

        return result;
    }

    public static class UnilateralLine {
        private String id;
        private String sCen;//出发分拨
        private String sPro;//出发省
        private String eCen;//到达分拨
        private String ePro;//到达省
        //9.6m/17.5m
        private String tType;//车型

        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}
