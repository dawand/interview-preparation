package OnlineTest;

/**
 * Given a binary string S of an integer:
 * if the number is even: divide it by two, otherwise subtract it by 1
 * Output: the number of steps it takes for the number to reach 0
 */
public class BinaryReductionSteps {
    public static void main(String[] args) {
        String binaryString = Integer.toBinaryString(28);
        int num = Integer.parseInt(binaryString, 2);
        System.out.println(solution(num));
    }

    private static int solution(int num){
        if (num == 0) // base case
            return 0;

        if (num % 2 == 0) // even number
            return 1 + solution(num/2);
        else // odd number
            return 1 + solution(num - 1);
    }
}
