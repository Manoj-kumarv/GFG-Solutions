class Solution {
    static ArrayList<Integer> leaders(int arr[]) {
        // code here
        ArrayList<Integer> arr2 = new ArrayList<>();
        int max = arr[arr.length - 1];
        arr2.add(max);
        for(int i = arr.length - 2; i>=0 ; i--){
            if(arr[i]>=max){
                max = arr[i];
                arr2.add(arr[i]);
            }
        }
        Collections.reverse(arr2);
        return arr2;
}
}
