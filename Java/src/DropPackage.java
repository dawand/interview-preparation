public class DropPackage {

    private static int numberOfDrops(int num, int[] requests) {
        int result = 0;

        for (int i = 3; i < num; i++) {

            if (requests[i] == requests[i - 3]
                    || (i > 19 && requests[i] - requests[i - 20] < 10)
                    || (i > 59 && requests[i] - requests[i - 60] < 60))
                result++;
        }

        return result;
    }

    public static void main(String[] args) {
        // /* This is a // // comment */
        /* This is also a comment // More comments */
//        /* This is also a comment /* More comments */ */
        /* Here is a comment **** */

        short num = 26;
        int[] requests = {1,1,1,1,2,2,2,3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,7,11,11,11,11};
        System.out.println(numberOfDrops(num+1, requests));
    }
}