import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingInteger {
    Integer[] input1 = {0, 1, 3, 2, 4};
    Integer[] input2 = {5, 1, 3, 7, 9, 2, 6, 8};
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
        new MissingInteger().run();
    }

    int solution(int[] A) {
        int size = A.length;
        if (size == 0) return 1; // empty array
        if (size == 1) return A[0] + 1; // single element

        Arrays.sort(A);
        if (A[size - 1] < 0) return 1; // negative numbers
        if (A[size - 1] == 1) return 2;

        // System.out.println(Arrays.toString(A));

        int i = 0;
        int j = 1; // start of the sequence

        while (i < size) {
            // System.out.println(i + " " + j);
            if (i != size - 1 && A[i] == A[i + 1]) {
                i++;
            } else {
                if (A[i] == j) {
                    i++;
                    j++;
                } else {
                    return j;
                }
            }
        }

        return j;
    }
}
