/**
 * Created by newuser on 11/21/15.
 */
public class LinkedList<T> {


    node<T> head;
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

    public void insert(T data){
        node newnode = new node(data);

        if (empty()){
            head = new node<T>(data);
        }else{
            node current = head;
            while (current.next!=null){

                current=current.next;

            }

            current.next = newnode;
        }
    }

    public void delete(T data){
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
