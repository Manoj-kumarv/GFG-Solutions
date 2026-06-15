class Solution {
    public boolean isFibonacci(int n) {
        if (n == 0 || n == 1) {
            return true;
        }

        int a = 0;
        int b = 1;

        while (b <= n) {
            if (b == n) {
                return true;
            }
            int c = a + b;
            a = b;
            b = c;
        }

        return false;
    }
}