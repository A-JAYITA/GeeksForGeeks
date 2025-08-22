class Solution {
    public int median(int[][] mat) {
        // code here
        int m = mat.length;
        int n = mat[0].length;
        int half = (m * n)/2;
        List<Integer> list = new ArrayList<>();
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                list.add(mat[i][j]);
            }
        }
        Collections.sort(list);
        return list.get(half);
    }
}