
class Solution {
    void enqueue(Queue<Integer> q, int x) {
        q.add(x);
    }
    void dequeue(Queue<Integer> q) {
        if(!q.isEmpty()){
            q.poll();
        }
    }
    int front(Queue<Integer> q) {
        if(!q.isEmpty()){
            return q.peek();
        }
        return -1;
    }
    String find(Queue<Integer> q, int y) {
        if(q.contains(y)){
            return "Yes";
        }
        return "No";
    }
}