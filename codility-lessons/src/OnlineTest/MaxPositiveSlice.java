package OnlineTest;

public class MaxPositiveSlice {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {1,0,3,-3,2,1,-2,0,3,4,0,-1})); // 7
        System.out.println(solution(new int[] {-2,-1})); // -1

    }

    private static int solution(int A[]){
        int maxSlice = Integer.MIN_VALUE;
        int localSlice = 0;

        for (int value : A) {
            if (value >= 0) {
                localSlice += value;
                if (localSlice > maxSlice)
                    maxSlice = localSlice;
            }
            else
                localSlice = 0;
        }

        return maxSlice == Integer.MIN_VALUE? -1: maxSlice;
    }
}
