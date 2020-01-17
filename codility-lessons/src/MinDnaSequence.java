public class MinDnaSequence {
    public int[] solution(String S, int[] P, int[] Q) {
        char[] sequence = S.toCharArray();
        int[] result = new int[P.length];
        int j=0;

        // System.out.println(Arrays.toString(sequence));

        for(int i=0;i<P.length;i++){
            int start = P[i];
            int end = Q[i];
            int min = Integer.MAX_VALUE;

            // System.out.println(start + " " + end);

            while(start<=end){
                if(sequence[start] == 'A'){
                    min = 1;
                    break;
                }
                else if(sequence[start] == 'C')
                    min = Math.min(min, 2);
                else if(sequence[start] == 'G')
                    min = Math.min(min, 3);
                else if(sequence[start] == 'T')
                    min = Math.min(min, 4);

                start++;
            }

            result[j] = min;
            j++;
        }

        return result;
    }
}
