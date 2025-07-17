class Solution {
    private boolean checkPalindrome(String s)
    {
        if(s.length()==1)return true;
        StringBuilder ns = new StringBuilder(s);
        return ns.reverse().toString().equals(s);
    }
    public void solve(String s,int i,ArrayList<ArrayList<String>>res,ArrayList<String>str)
    {
        if(i>=s.length())
        {
            res.add(new ArrayList<>(str));
            return;
        }
        for(int idx = i+1;idx<=s.length();idx++)
        {
            if(checkPalindrome(s.substring(i,idx)))
            {
                str.add(s.substring(i,idx));
                solve(s,idx,res,str);
                str.remove(str.size()-1);
            }
        }
    }
    public ArrayList<ArrayList<String>> palinParts(String s) {
        // code here
        ArrayList<ArrayList<String>>res = new ArrayList<>();
        ArrayList<String>str = new ArrayList<>();
        solve(s,0,res,str);
        return res;
    }
}