class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;

        if (arr[0] == 0) return -1;

        int maxReach = arr[0];
        int steps = arr[0];
        int jumps = 1;

        for (int i = 1; i < n; i++) {

            // reached last index
            if (i == n - 1) return jumps;

            // update how far we can go
            maxReach = Math.max(maxReach, i + arr[i]);

            steps--;

            // need to jump
            if (steps == 0) {
                jumps++;

                if (i >= maxReach) return -1;

                steps = maxReach - i;
            }
        }
        return -1;
    }
}