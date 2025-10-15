class Solution {
    // Function to return Breadth First Search Traversal of given graph.
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size(); // size of adj list is same as number of vertices in graph
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] vis = new boolean[V];
        queue.offer(0);
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            if(vis[curr] == false) {
                list.add(curr);
                vis[curr] = true;
                for(int i=0; i<adj.get(curr).size(); i++) {
                    queue.offer(adj.get(curr).get(i));
                }
            }
        }
        return list;
    }
}