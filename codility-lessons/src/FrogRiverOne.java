import java.util.*;

public class FrogRiverOne {

    Integer[] input1 = {1, 2, 3, 4, 3, 3, 1, 2, 4, 4, 2, 1}; //3
    Integer[] input2 = {1, 2, 3, 2, 3, 3, 1, 2, 2, 4, 2, 1}; // 9
    Integer[] input3 = {1, 2, 3, 2, 3, 3, 1, 2, 4, 4, 2, 1}; // 8

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private void run() {
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);
        int X = 4;
        for (Integer[] input : inputList) {
            int result = solution(X, Arrays.stream(input).mapToInt(i -> i).toArray());
            results.add(result);
        }

        System.out.println(results.toString());
    }

    public static void main(String[] args) {
        new FrogRiverOne().run();
    }


    int solution(int X, int[] A) {
        int size = A.length;
        if (X > size) return -1;

        Set<Integer> leaves = new HashSet<>();

        for(int i=0;i<size;i++){
            if (A[i] < X){
                leaves.add(A[i]);
            } else if(A[i] == X && leaves.size() == X - 1) {
                return i;
            }
        }

        return -1;
    }

}
