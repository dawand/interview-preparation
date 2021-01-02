import java.util.ArrayList;
import java.util.List;

public class LargestTotalSum {
    public static void main(String[] args) {
        int[] arr = {-4,1,-2,8,6,-4,3};
        System.out.println(getLargestSubarray(arr));
        
    }

    private static int getLargestSubarray(int[] A) {
//        int maxSum = arr[0];
//        int maxSoFar = arr[0];
//
//        for (int i = 1; i < arr.length; i++) {
//            maxSoFar = Math.max(arr[i], maxSoFar + arr[i]);
//            maxSum = Math.max(maxSum, maxSoFar);
//        }
//        return maxSum;

        int maxSoFar=A[0], maxEndingHere=A[0];
        for (int i=1;i<A.length;++i){
            maxEndingHere= Math.max(maxEndingHere+A[i],A[i]);
            maxSoFar=Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
