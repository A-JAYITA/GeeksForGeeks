class Solution {
    public void nearlySorted(int[] arr, int k) {
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            if(arr[i] > arr[i+1]){
                int start = ((i+1) - k) < 0 ? 0 : (i+1) - k;
                for(int j = start;j<i+1;j++){
                    if(arr[i+1] < arr[j]){
                        int temp = arr[j];
                        arr[j] = arr[i+1];
                        arr[i+1] = temp;
                    }
                }
            }
        }
    }
}
