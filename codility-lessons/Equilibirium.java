import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Equibilirium {

    Integer[] input1 = {5, 2, 7, 10};
    Integer[] input2 = {100, -25};
    Integer[] input3 = {-1000, 1000, -500, 990};

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private void run() {
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);

        for (Integer[] input : inputList) {
            int result = solution(Arrays.stream(input).mapToInt(i -> i).toArray());
            results.add(result);
        }

        System.out.println(results.toString());
    }

    public static void main(String[] args) {
        new Equibilirium().run();
    }

    private int solution(int[] A) {
        int size = A.length;
        int leftSum = 0;
        int rightSum = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int value : A) {
            rightSum += value;
        }

        for (int i=0;i<size-1;i++) {
            leftSum += A[i];
            rightSum -= A[i];
            minDiff = Math.min(minDiff, Math.abs(leftSum - rightSum));
        }

        return minDiff;
    }
}

