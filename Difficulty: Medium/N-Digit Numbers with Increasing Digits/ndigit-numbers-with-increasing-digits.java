class Solution {
    public static ArrayList<Integer> increasingNumbers(int n) {
        ArrayList<Integer> result = new ArrayList<>();

        // If n > 10, impossible (only digits 0–9)
        if (n > 10) return result;

        // Special case: n == 1
        if (n == 1) {
            for (int i = 0; i <= 9; i++) {
                result.add(i);
            }
            return result;
        }

        // Start recursion for n >= 2
        for (int i = 1; i <= 9; i++) {
            dfs(n, 1, i, result);
        }

        return result;
    }

    private static void dfs(int n, int len, int num, ArrayList<Integer> result) {
        if (len == n) {
            result.add(num);
            return;
        }

        int lastDigit = num % 10;

        for (int next = lastDigit + 1; next <= 9; next++) {
            dfs(n, len + 1, num * 10 + next, result);
        }
    }
}