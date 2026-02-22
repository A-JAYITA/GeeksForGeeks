/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution { 
    public Node merge(Node head1,Node head2){
         Node newHead=null; 
         Node temp=null; 
         Node curr1=head1; 
         Node curr2=head2; 
         while(curr1!=null && curr2!=null){
              if(curr1.data <=curr2.data){
                  if(newHead==null){
                     newHead=new Node(curr1.data);  
                     temp=newHead;
                  } 
                  else{
                      temp.bottom=new Node(curr1.data); 
                      temp=temp.bottom;
                  }
                  curr1=curr1.bottom;
              } 
              else{
                   if(newHead==null){
                     newHead=new Node(curr2.data);  
                     temp=newHead;
                  } 
                  else{
                      temp.bottom=new Node(curr2.data); 
                      temp=temp.bottom;
                  } 
                  curr2=curr2.bottom;
              }
         } 
         while(curr1!=null){
                  if(newHead==null){
                     newHead=new Node(curr1.data);  
                     temp=newHead;
                  } 
                  else{
                      temp.bottom=new Node(curr1.data); 
                      temp=temp.bottom;
                  }
                  
             curr1=curr1.bottom;
         } 
        while(curr2!=null){
                  if(newHead==null){
                     newHead=new Node(curr2.data);  
                     temp=newHead;
                  } 
                  else{
                      temp.bottom=new Node(curr2.data); 
                      temp=temp.bottom;
                  }
             curr2=curr2.bottom;
         }  
        return newHead;
    }
    public Node flatten(Node root) {
        Node curr=root.next;
        Node res=root;
        while(curr!=null){
           res=merge(res,curr);    
            curr=curr.next;
        } 
        return res;
    }
}