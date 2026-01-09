class Solution {
    public int countAtMostK(int arr[], int k) {
          int i = 0;
        int j = 0;
        int n = arr.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        
        while(j < n){
            map.put(arr[j] , map.getOrDefault(arr[j] , 0) + 1);
            
            while(map.size() > k){
                map.put(arr[i] , map.getOrDefault(arr[i] , 0) - 1);
                if(map.get(arr[i]) == 0){
                    map.remove(arr[i]);
                }
                i++;
            }
            ans += (j - i + 1);
            j++;
        }
        return ans;
    }
}
