import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingElement {

    Integer[] input1 = {3, 2, 4};
    Integer[] input2 = {5,1,3,7,9,2,6,8};
//    Integer[] input3 = {9,3,3,9,1,1,1,1,2,2,2};

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private void run(){
        inputList.add(input1);
        inputList.add(input2);

        for(Integer[] input: inputList){
            int result = solution(Arrays.stream(input).mapToInt(i->i).toArray());
            results.add(result);
        }

        System.out.println(results.toString());
    }

    public static void main(String[] args) {
        new MissingElement().run();
    }

    int solution(int[] A) {
        int size = A.length;
        if (size == 0) return 1;
        if (size == 1) return A[0]==1? 2: A[0]-1;

        Arrays.sort(A);
        int i;
        for(i=0;i<size;i++){
            if(A[i] != i+1)
                return i+1;
        }

        return i+1;
    }
}

