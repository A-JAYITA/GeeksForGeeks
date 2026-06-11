class Solution {
    public int findIndex(String s) {
        return (int) s.chars()
                      .filter(ch -> ch == ')')
                      .count();
    }
}