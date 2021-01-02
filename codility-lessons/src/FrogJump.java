import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrogJump {

    Integer[] input1 = {25, 50, 10};
//    Integer[] input2 = {9,3,3,7,9,6,6,7,8};
//    Integer[] input3 = {9,3,3,9,1,1,1,1,2,2,2};

    List<Integer[]> inputList = new ArrayList<>();

    ArrayList<Integer> results = new ArrayList<>();

    private void run(){
        inputList.add(input1);

        for(Integer[] input: inputList){
            int result = solution(input[0], input[1], input[2]);
            results.add(result);
        }

        System.out.println(results.toString());
    }
    public static void main(String[] args) {
        new FrogJump().run();
    }

    private int solution(int X, int Y, int D) {
        if ((Y < X) || (Y == X)) return 0;
        if ((Y - X) < D) return 1;

        int steps = (Y - X) / D;
        int remaining = (Y - X) % D;

        if(remaining != 0) return steps + 1;

        return steps;
    }
}
