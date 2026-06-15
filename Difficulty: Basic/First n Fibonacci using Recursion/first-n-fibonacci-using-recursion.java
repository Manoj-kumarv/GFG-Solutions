// User function Template for Java

class Solution {
    // Function to return list containing first n fibonacci numbers.
    public static int[] fibonacciNumbers(int n) {
        // Your code here
                int[] fib=new int[n];
        fib[0]=0;
        if(n==1) return fib;
        fib[1]=1;
        
        for(int i=2;i<n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib;
    }
        
}