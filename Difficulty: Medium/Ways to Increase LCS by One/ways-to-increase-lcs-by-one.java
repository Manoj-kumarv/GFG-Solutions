class Solution {
    public int waysToIncreaseLCSBy1(String s1, String s2) {
        int n1 = s1.length(), n2 = s2.length();

        int[][] dp1 = new int[n1 + 1][n2 + 1];
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp1[i][j] = dp1[i - 1][j - 1] + 1;
                else
                    dp1[i][j] = Math.max(dp1[i - 1][j], dp1[i][j - 1]);
            }
        }

        int L = dp1[n1][n2];

        int[][] dp2 = new int[n1 + 2][n2 + 2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp2[i][j] = dp2[i + 1][j + 1] + 1;
                else
                    dp2[i][j] = Math.max(dp2[i + 1][j], dp2[i][j + 1]);
            }
        }

        int ways = 0;

        for (int i = 0; i <= n1; i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                boolean valid = false;
                for (int j = 0; j < n2; j++) {
                    if (s2.charAt(j) == c) {
                        if (dp1[i][j] + dp2[i][j + 1] == L) {
                            valid = true;
                            break;
                        }
                    }
                }
                if (valid) ways++;
            }
        }

        return ways;
    }
}