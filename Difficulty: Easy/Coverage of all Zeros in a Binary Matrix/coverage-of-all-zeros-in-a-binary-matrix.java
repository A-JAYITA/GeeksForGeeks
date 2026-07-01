class Solution {
    public int findCoverage(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int row[] = new int[m];
        int col[] = new int[n];
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i < m ; i++){
            int zeros = 0;
            for(int j = 0 ; j < n ; j++){
                if(mat[i][j] == 0){
                    zeros++;
                    ans+=row[i];
                    ans+=col[j];
                    map.put(j , map.getOrDefault(j , 0)+1);
                }else{
                    ans+=zeros;
                    zeros = 0;
                    row[i]=1;
                    col[j] =1;
                    if(map.containsKey(j)){
                        ans+=map.get(j);
                        map.remove(j);
                    }
                }
            }
        }return ans;
    }
}