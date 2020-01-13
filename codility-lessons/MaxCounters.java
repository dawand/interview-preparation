import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxCounters {
    Integer[] input1 = {1, 2, 3, 4, 3, 3, 1, 2, 4, 4, 2, 1}; //3
    Integer[] input2 = {1, 2, 3, 2, 3, 3, 1, 2, 2, 4, 2, 1}; // 9
    Integer[] input3 = {1, 2, 3, 2, 3, 3, 1, 2, 4, 4, 2, 1}; // 8

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer[]> results = new ArrayList<>();

    private void run() {
        inputList.add(input1);
        inputList.add(input2);
        inputList.add(input3);
        int X = 4;
        for (Integer[] input : inputList) {
            int[] result = solution(X, Arrays.stream(input).mapToInt(i -> i).toArray());
//            results.add(result);
            System.out.println(Arrays.toString(result));
        }

//        System.out.println(results.toString());
    }

    public static void main(String[] args) {
        new MaxCounters().run();
    }

    int[] solution(int N, int[] A) {
        int size = A.length;
        int currMax = 0;
        int[] result = new int[N];

        for(int i=0;i<result.length;i++) result[i] = 0;

        for(int i=0; i<size; i++){
            if(A[i] < N+1){
                result[A[i]-1] += 1;
                currMax = Math.max(currMax, result[A[i]-1]);
            } else if (A[i] == N+1){
                for(int j=0; j<N;j++){
                    result[j] = currMax;
                }
            }
        }

        return result;
    }
}
