package DynamicProgramming;

import java.util.Arrays;

public class HouseRobber {

    static int[] memo;

    public static void main(String[] args) {
        System.out.println(rob(new int[] {2,1,1,2}));
    }

    private static int rob(int[] nums){
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    private static int rob(int[] nums, int i){
        if (i < 0) return 0;
        if (memo[i] >= 0) return memo[i];

        int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
        memo[i] = result;
        return result;
    }
}
