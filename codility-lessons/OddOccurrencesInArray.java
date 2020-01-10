import java.util.*;

public class OddOccurrencesInArray {

    Integer[] input1 = {1};
    Integer[] input2 = {9,3,3,7,9,6,6,7,8};
    Integer[] input3 = {9,3,3,9,1,1,1,1,2,2,2};

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private Solution sol = new Solution();

    private void run(){
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);

        for(Integer[] input: inputList){
            int result = sol.solution(Arrays.stream(input).mapToInt(i->i).toArray());
            results.add(result);
        }

        System.out.println(results.toString());
    }
    public static void main(String[] args) {
        new OddOccurrencesInArray().run();
    }

    static class Solution {
        int solution(int[] A) {
            HashMap<Integer, Integer> occurencesMap = new HashMap<>();
            int size = A.length;

            for (int value : A)
                if (occurencesMap.containsKey(value)) {
                    occurencesMap.put(value, occurencesMap.get(value) + 1);
                } else {
                    occurencesMap.put(value, 1);
                }

            for (Map.Entry<Integer, Integer> entry: occurencesMap.entrySet())
                if (entry.getValue() % 2 != 0)
                    return entry.getKey();

            throw new RuntimeException("This should not happen!");
        }
    }
}
