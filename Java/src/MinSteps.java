import java.util.Arrays;

public class MinSteps {
    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        System.out.println(getMinStepsMemo(n, 0, dp));
        System.out.println(getMinStepsTab(n));
    }

    private static int getMinStepsMemo(int n, int total, int[] dp) {
        if (n == 1) return 0;
        if (dp[n] != 0) {
            return dp[n];
        }

        total = 1 + getMinStepsMemo(n - 1, total, dp);

        if (n % 2 == 0) {
            total = 1 + getMinStepsMemo(n / 2, total, dp);
        }
        if (n % 3 == 0) {
            total = 1 + getMinStepsMemo(n / 3, total, dp);
        }

        dp[n] = total;
        return total;
    }

    private static int getMinStepsTab(int n) {
        int[] tab = new int[n + 1];
        Arrays.fill(tab, Integer.MAX_VALUE);

        tab[1] = 0;

        for (int i = 1; i < n; i++) {
//            if (i + 1 <= n) {
                tab[i + 1] = Math.min(tab[i] + 1, tab[i+1]);
//            }
            if (i * 2 <= n) {
                tab[i * 2] = Math.min(tab[i] + 1, tab[i*2]);
            }
            if (i * 3 <= n) {
                tab[i * 3] = Math.min(tab[i] + 1, tab[i*2]);
            }
        }

        System.out.println(Arrays.toString(tab));

        return tab[n];
    }
}
