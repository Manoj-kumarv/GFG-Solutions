// User function Template for Java

class Solution {
    public long find_fact(int n) {
        if (n == 0){
            return 1;
        }
        return n* find_fact(n-1);
        
    }
}