package OnlineTest;

/**
 * Given an array of untangled necklaces with beads with each bead pointing to the next one,
 * Find the longest necklace with the highest number of beads
 */
public class LongestNecklaceBeads {
    public static void main(String[] args) {
        System.out.println(solution(new int[] {5,4,0,3,1,6,2}));
    }

    static int solution(int[] A){
        int longestNecklace = 0;
        boolean[] visited = new boolean[A.length];

        for (int i = 0; i < A.length; i++) {
            if (visited[i]) continue;
            int j = A[i];
            int counter = 1;

            while(i != j){
                j = A[j];
                counter++;
                visited[j] = true;
            }

            if (counter>longestNecklace)
                longestNecklace = counter;
        }

        return longestNecklace;
    }
}
