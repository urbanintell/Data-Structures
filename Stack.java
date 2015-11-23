/**
 * Created by newuser on 11/21/15.
 */
public class Stack<T> {

    node<T> top;

    public Stack(){
        top=null;
    }

    public boolean empty(){
        return(top==null);
    }

    public void push(T data){
        node newnode = new node(data);

        if (empty()){
            top = new node(data);
        }else{
          newnode.next = top;
          top= newnode;

        }
    }

    public T pop(){
        if(!empty()){
            node<T> oldTop = top;
            if(top.next!=null){

            top= top.next;
            return oldTop.data;
        }

            top=null;
            return oldTop.data;
        }
        return null;
    }
    public T peek(){

        return empty() ? top.data:null;

    }




}
