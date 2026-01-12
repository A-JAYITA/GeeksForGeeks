class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        // code here
        
        ArrayList<Integer> ansList = new ArrayList<>();
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        for(int i = 0 ; i < arr.length ; i++){
            while(!dq.isEmpty() && arr[dq.getLast()] < arr[i]){
                dq.removeLast();
            }
            dq.addLast(i);
            
            if(dq.getFirst() + k == i){
                dq.removeFirst();
            }
            if(i >= k-1){
                ansList.add(arr[dq.getFirst()]);
            }
        }
        return ansList;
    }
}