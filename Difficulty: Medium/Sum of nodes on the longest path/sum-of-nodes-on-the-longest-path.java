/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
public class Solution {
    static class Result {
        int maxSum = 0;
        int maxLen = 0;
    }
    // Recursive function to find the longest path and maximum sum
    static void findLongestPathSum(Node root, int sum, int len, Result res) {
        if (root == null) {
            if (len > res.maxLen) {
                res.maxLen = len;
                res.maxSum = sum;
            } else if (len == res.maxLen) {
                if (sum > res.maxSum)
                    res.maxSum = sum;
            }
            return;
        }
        findLongestPathSum(root.left, sum + root.data, len + 1, res);
        findLongestPathSum(root.right, sum + root.data, len + 1, res);
    }
    static int sumOfLongRootToLeafPath(Node root) {
        Result res = new Result();
        findLongestPathSum(root, 0, 0, res);
        return res.maxSum;
    }
    // Helper to build tree from array
    static Node buildTree(String[] arr) {
        if (arr.length == 0 || arr[0].equals("N")) return null;
        Node root = new Node(Integer.parseInt(arr[0]));
        Node[] nodes = new Node[arr.length];
        nodes[0] = root;
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (nodes[i] != null) {
                if (j < arr.length && !arr[j].equals("N")) {
                    nodes[i].left = new Node(Integer.parseInt(arr[j]));
                    nodes[j] = nodes[i].left;
                }
                j++;
                if (j < arr.length && !arr[j].equals("N")) {
                    nodes[i].right = new Node(Integer.parseInt(arr[j]));
                    nodes[j] = nodes[i].right;
                }
                j++;
            }
            i++;
        }
        return root;
    }
}
