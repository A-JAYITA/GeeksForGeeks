class Solution {
    
    public void solve(ArrayList<ArrayList<Integer>> graph, int curr, boolean[] isVisited, ArrayList<Integer> ans){
        ans.add(curr);
        isVisited[curr]=true;  
        
        for(int i = 0; i<graph.get(curr).size();i++){
            int next = graph.get(curr).get(i);
            if(!isVisited[next]){  
                solve(graph, next, isVisited, ans);
            }
        }
    }
    
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] isVisited = new boolean[adj.size()]; 
        solve(adj, 0, isVisited, ans); 
        return ans;
    }
}