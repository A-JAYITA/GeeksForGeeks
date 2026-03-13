class Solution {
    
    StringBuilder sb;
    ArrayList<String> result;
    
    public boolean checkValid(StringBuilder sb){
        
        String[] domains = sb.toString().split("\\.");
        if (domains.length != 4) {
            return false;
        }
        for(String domain : domains){
         
            int num = Integer.parseInt(domain);
            if(domain.isEmpty()){
                return false;
            }
            if(domain.length() > 3 || num > 255){
                return false;
            }
            if(domain.length() > 1 && domain.charAt(0) == '0'){
                return false;
            }
        }
        return true;
    }
    
    public void solve(int point, String s, int prev) {
        
        if (point == 3) {
            String lastPart = s.substring(prev);
            sb.append(lastPart);
            if(checkValid(sb)){
                result.add(sb.toString());
            }
            sb.delete(sb.length() - lastPart.length(), sb.length());
            return;
        }
        
        for (int i = 1; i <= 3; i++) {
            if (prev + i <= s.length()) {
                int currentLength = sb.length(); // Save state
                
                sb.append(s.substring(prev, prev + i));
                sb.append('.');
                
                solve(point + 1, s, prev + i);
                
                sb.setLength(currentLength); // backtracking!
            }
        }
    }
    public ArrayList<String> generateIp(String s) {
        // code here
        
        result = new ArrayList<>();
        sb = new StringBuilder("");
        
        if(s.length() >= 4 && s.length() <= 12){
            solve(0 , s , 0);
        }
        return result;
    }   
}