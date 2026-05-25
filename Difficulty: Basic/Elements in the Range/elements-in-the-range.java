class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        // code here
        Arrays.sort(arr);
        int count=0;
        for(int i :arr){
            if(i>=start && i<=end){
               count++;
            }
        }
        return count==(end-start+1);
    }
}