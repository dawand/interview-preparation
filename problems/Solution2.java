import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

    public List<PairInt> optimizeUtilization(List<PairInt> foregroundAppsList, List<PairInt> backgroundAppsList) {
        List<PairInt> list = new ArrayList<>();

        Map<Integer, List<PairInt>> map = new HashMap<>();

        for (PairInt pairInt : foregroundAppsList) {
            for (PairInt anInt : backgroundAppsList) {
                int f2 = pairInt.second;
                int b2 = anInt.second;
                List<PairInt> sums = map.getOrDefault(f2 + b2, new ArrayList<>());
                sums.add(new PairInt(pairInt.first, anInt.first));
                map.put(f2 + b2, sums);
            }
        }

        map.keySet().forEach(System.out::println);

        return list;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        List<PairInt> foregroundAppsList = new ArrayList<>();
        foregroundAppsList.add(new PairInt(1,2));
        foregroundAppsList.add(new PairInt(2,4));
        foregroundAppsList.add(new PairInt(3,5));

        List<PairInt> backgroundAppsList = new ArrayList<>();
        backgroundAppsList.add(new PairInt(1,3));
        backgroundAppsList.add(new PairInt(2,5));

        System.out.println(s.optimizeUtilization(foregroundAppsList, backgroundAppsList));
    }

    static class PairInt {

        int first;
        int second;

        PairInt(int first, int second){
            this.first = first;
            this.second = second;
        }
    }
}
