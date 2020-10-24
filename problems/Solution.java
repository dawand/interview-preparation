import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> cellCompute(int[] states, int days){
        List<Integer> list = new ArrayList<>();

        int[] tempStates = new int[8];
        int j = 0;

        while (j < days){
            tempStates[0] = states[1];

            for (int i = 1; i < 7; i++) {
                tempStates[i] = states[i-1] ^ states[i+1];
            }

            tempStates[7] = states[6];

            System.arraycopy(tempStates, 0, states, 0, 8);

            j++;
        }

        for (int i = 0; i < 8; i++) {
            list.add(states[i]);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.cellCompute(new int[] {1,0,0,0,0,1,0,0}, 1));
        System.out.println(s.cellCompute(new int[] {1,1,1,0,1,1,1,1}, 2));
    }
}
