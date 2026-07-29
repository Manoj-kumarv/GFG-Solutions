class Solution {
    int minSubsets(int arr[]) {
        // code here
        int count = 1;
        Arrays.sort(arr);
        for(int i=0; i<arr.length - 1; i++){
            if(arr[i+1]-arr[i] != 1){
                count ++;
            }
        }
        return count;
    }
}