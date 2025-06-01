class Solution {
    int countPairs(int[][] mat1, int[][] mat2, int x) {
        int n = mat1.length;
        int count = 0;
        
        // Use a HashSet to store all required values (x - a)
        java.util.HashSet<Integer> neededValues = new java.util.HashSet<>();
        
        // Traverse mat1 and store (x - a) values
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                neededValues.add(x - mat1[i][j]);
            }
        }
        
        // Traverse mat2 and count how many values are present in the set
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (neededValues.contains(mat2[i][j])) {
                    count++;
                }
            }
        }
        
        return count;
    }
}
