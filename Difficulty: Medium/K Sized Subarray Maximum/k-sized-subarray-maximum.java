class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        Deque<Integer> dq = new ArrayDeque<>();
        int idx = 0;
        int n = arr.length;
        for(int right = 0; right < n; right++){
            if(!dq.isEmpty() && dq.peekFirst() < right - k + 1)
            dq.pollFirst();
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[right]) dq.pollLast();
            dq.offerLast(right);
            if(right >= k - 1){
                list.add(arr[dq.peekFirst()]);
            }
        }
        return list;
    }
}