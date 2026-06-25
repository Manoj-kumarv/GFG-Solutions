class Solution {
    public static String reverseString(String s) {
        // code here
        String x = "";
        for(int i = s.length()-1; i>=0; i--){
            x += s.charAt(i);
        }
        return x;
    }
}