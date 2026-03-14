/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        this.data = val;
        this.left = null;
        this.right = null;
    }
}
*/
class Solution {
    class CustomNode{
        Node node;
        int col;
        CustomNode(Node node , int col){
            this.node = node;
            this.col = col;
        }
    }
    public ArrayList<Integer> topView(Node root) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        int minCol = Integer.MAX_VALUE;
        int maxCol = Integer.MIN_VALUE;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<CustomNode> q = new LinkedList<>();
        
        q.offer(new CustomNode(root , 0));
        
        while(!q.isEmpty()){
            CustomNode currNode = q.poll();
            Node node = currNode.node;
            int col = currNode.col;
            
            if(!map.containsKey(col)){
                map.put(col , node.data);
                minCol = Math.min(minCol , col);
                maxCol = Math.max(maxCol , col);
            }
            
            if(node.left != null){
                q.offer(new CustomNode(node.left , col - 1));
            }
            if(node.right != null){
                q.offer(new CustomNode(node.right , col + 1));
            }
        }
        
        for(int i = minCol ; i <= maxCol ; i++){
            result.add(map.get(i));
        }
        return result;
    }
}