/*
class Node {
    int data;
    Node left, right;

    Node(int d)
    {
        data = d;
        left = right = null;
    }
} */

class Solution {
    private int height(Node root){
        if(root==null)return 0;
        return Math.max(1+height(root.left),1+height(root.right));
    }
    public boolean isBalanced(Node root) {
        if(root==null) return true;
        int l=height(root.left);
        int r=height(root.right);
        if(Math.abs(l-r)>1)return false;
        boolean left=isBalanced(root.left);
        boolean right=isBalanced(root.right);
        if(!left || !right)return false;
        return true;
    }
}