/*The structure of the node of the queue is
class QueueNode
{
    int data;
    QueueNode next;
    QueueNode(int a)
    {
        data = a;
        next = null;
    }
}*/

class MyQueue {
    QueueNode front, rear;
    void push(int a) {
        QueueNode newNode=new QueueNode(a);
        if(rear==null){
            front=rear=newNode;
        }else{
            rear.next=newNode;
            rear=newNode;
        }
    }
    int pop() {
        if(front==null){
            return -1;
        }
        int value=front.data;
        front=front.next;
        if(front==null){
            rear=null;
        }
        return value;
    }
}