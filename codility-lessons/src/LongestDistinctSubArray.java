import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestDistinctSubArray {
    Integer[] input1 = {0, 1, 3, 2, 4, 2};
    Integer[] input2 = {5, 1, 3, 7, 5, 9, 2, 3, 5, 6, 8};
//    Integer[] input3 = {9,3,3,9,1,1,1,1,2,2,2};

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private void run() {
        inputList.add(input1);
        inputList.add(input2);

        for (Integer[] input : inputList) {
            int result = solution(Arrays.stream(input).mapToInt(i -> i).toArray());
            results.add(result);
        }

        System.out.println(results.toString());
    }

    public static void main(String[] args) {
        new LongestDistinctSubArray().run();
    }

    int solution(int[] A){
        int size = A.length;
        if (size == 1) return 1;
        int maxLength = 0;
        int i = 0;
        int j = 1;

        while(j < size) {
            System.out.println(i + " " + j);
            if (A[i] == A[j]) {
                i = j;
                j++;
            } else {
                maxLength = Math.max(maxLength, j - i);
                j++;
            }
        }
        return maxLength;
    }
}
