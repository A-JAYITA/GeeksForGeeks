class Solution {
    public ArrayList<Integer> countXInRange(int[] arr, int[][] queries) {
        // code here
        ArrayList<Integer>ans = new ArrayList<>();
        for(int[] q:queries) {
            int s = q[0], e = q[1], val = q[2];
            int fi = BS(arr, val, true);
            if(fi == -1) ans.add(0);
            else {
                int si = BS(arr, val , false);
                int l = Math.max(fi, s), r = Math.min(si, e);
                if(r-l>=0) ans.add(r-l+1);
                else ans.add(0);
            }
        }
        return ans;
    }
    
    private int BS(int[] arr, int tar, boolean left) {
        
        int n = arr.length, i = 0, j = n-1, ans = -1;
        while(i<=j) {
            int m = i+(j-i)/2;
            if(arr[m] == tar) {
                ans = m;
                if(left) {
                    j = m-1;
                } else i = m+1;
            } else if(arr[m] > tar) j = m-1;
            else i = m+1;
        }
        
        return ans;
    }
}