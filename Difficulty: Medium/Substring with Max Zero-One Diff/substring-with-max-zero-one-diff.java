class Solution {
    int maxSubstring(String s) {
        int mx = -1, zc = 0, oc = 0, n = 0;
        for(char c : s.toCharArray()){
            if(c == '0'){
                zc++;
            }
            else{
                oc++;
                n++;
            }
            if(oc > zc){
                zc = 0;
                oc = 0;
            }
            mx = Math.max(zc - oc, mx);
            
        }
        return (n == s.length()) ? -1 : mx;
    }
}