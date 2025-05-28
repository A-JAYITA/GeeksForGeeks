class Solution{
    public boolean ValidCorner(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        HashSet<String> seenPairs=new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] == 1) {
                    for (int k = j + 1; k < cols; k++) {
                        if (mat[i][k] == 1){
                            String pair=j+ "," + k;
                            if(seenPairs.contains(pair)){
                                return true;
                            }
                            seenPairs.add(pair);
                        }
                    }
                }
            }
        }
        return false;
    }

}