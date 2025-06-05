class Solution {
    public int countPaths(int[][] edges, int V, int src, int dest) {
        Node[] graph = new Node[V];
        for (int i = 0; i < V; i++) {
            graph[i] = new Node();
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            graph[u].add(v);
        }
        int[] dp = new int[V];
        for (int i = 0; i < V; i++) {
            dp[i] = -1;
        }
        return dfs(graph, dp, src, dest);
    }
    private int dfs(Node[] graph, int[] dp, int u, int dest) {
        if (u == dest) return 1;
        if (dp[u] != -1) return dp[u];

        int count = 0;
        for (int i = 0; i < graph[u].size; i++) {
            int v = graph[u].neighbors[i];
            count += dfs(graph, dp, v, dest);
        }
        dp[u] = count;
        return count;
    }
    class Node {
        int[] neighbors = new int[10];
        int size = 0;

        void add(int val) {
            if (size == neighbors.length) {
                int[] newArr = new int[size * 2];
                for (int i = 0; i < size; i++) {
                    newArr[i] = neighbors[i];
                }
                neighbors = newArr;
            }
            neighbors[size++] = val;
        }
    }
}
