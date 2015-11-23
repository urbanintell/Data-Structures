/**
 * Created by newuser on 11/21/15.
 */
public class Stack {

    node top;

    public Stack(){
        top=null;
    }

    public boolean empty(){
        return(top==null);
    }

    public void push(double data){
        node newnode = new node(data);

        if (empty()){
            top = new node(data);
        }else{
          newnode.next = top;
          top= newnode;

        }
    }

    public double pop(){
        if(!empty()){
            node oldTop = top;
            if(top.next!=null){

            top= top.next;
            return oldTop.data;
        }

            top=null;
            return oldTop.data;
        }
        return Double.MAX_VALUE;
    }
    public double peek(){

        return empty() ? top.data:null;

    }




}
