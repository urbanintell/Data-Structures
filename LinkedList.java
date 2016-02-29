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
           return Double.POSITIVE_INFINITY;
       }else{
           for(node current =head; current!=null; current=current.next){
               if (current.data==data){
                    return current.data;
               }
           }
       }
        return Double.POSITIVE_INFINITY;

    }

    public node reverse(node list){

        //empty or one element list is already reversed
        //1.)Base case (3|null) or (null)
        if (list==null||list.next==null){
            return list;
        }

        //List = (3| next ) ->  (4|null)
        node second = list.next;

        //unlink the list
        //List = (3|null)
        list.next = null;

                             //(4|null)
        node reversedList = reverse(second);

        //create link with original list
        //reversedList = (4|next) -> (3|null)
        second.next = list;

        return reversedList;
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

    class node {
        double data;
        node next;

        public node(double data){
            this.data = data;
            next = null;
        }
    }

}
