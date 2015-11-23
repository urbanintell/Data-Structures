/**
 * Created by newuser on 11/21/15.
 */
public class LinkedList {


    node head;
    public LinkedList(){
        head=null;
    }

    public boolean empty(){
       return (head==null);
    }

    public void display(){
        node current = head;
        while(current!=null){
            System.out.println(current.data);
            current=current.next;
        }
    }

    public void insert(double data){
        node newnode = new node(data);
        if (empty()){
            head = new node(data);
        }else{
            node current = head;
            while (current.next!=null){
                current=current.next;
            }
            current.next = newnode;
        }
    }

    public double search(double data){
       if (empty()){
           return Double.MAX_VALUE;
       }else{
           for(node current =head; current.next!=null; current=current.next){
               if (current.data==data){
                    return current.data;
               }
           }
       }
        return Double.MAX_VALUE;

    }

    public void delete(double data){
         if (empty()){
             System.out.println("EMPTY");
             return;
         }else if(head.data==data){
            if(!empty()) {
                head = head.next;
            }else {
                head=null;
            }
        }else{
             node current = head;
             node previous =head;
             while (current.next!=null){
                 if (current.data==data){
                    previous.next = current.next;
                 }
                 previous = current;
                 current=current.next;
             }
         }
    }


}
