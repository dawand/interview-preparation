public class MinAvgTwoSlice {

    public int solution(int[] A) {
        int size = A.length;
        double minavg1 = Double.MAX_VALUE;
        double minavg2 = Double.MAX_VALUE;
        double minavg = Double.MAX_VALUE;
        int minIndex = 0;

        for(int i=0;i<size-2;i++){
            minavg1 = (double) A[i]+A[i+1] / 2.0;
            minavg2 = (double) A[i]+A[i+1]+A[i+2] / 3.0;
            if(minavg1 < minavg){
                minavg = minavg1;
                minIndex = i;
            }
            if (minavg2 < minavg){
                minavg = minavg2;
                minIndex = i;
            }
        }

        minavg1 = (double) A[size-2] + A[size-1] / 2.0;
        if (minavg1 < minavg)
            minIndex = size-2;

        return minIndex;
    }
}
