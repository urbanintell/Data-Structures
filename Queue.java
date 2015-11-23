/**
 * Created by newuser on 11/21/15.
 */
public class Queue<T> {


    Stack<T> stack1;
    Stack<T> stack2;
    node top;
    public Queue(){
        top =null;
        stack1 = new Stack();
        stack2 = new Stack();
    }



    public boolean empty(){
        return (stack1.empty()&&stack2.empty());
    }

    public void display(){
        if (!empty()){
            System.out.println(stack1.pop());
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            while(!stack1.empty()){
                System.out.println(stack1.pop());
            }
        }
    }

    public void enqueue(T data){
        if (empty()){
            stack1.push(data);
            top = new node(stack1.peek());
        }else{
            stack2.push(data);
        }
    }

    public T dequeue(){

        if (!empty()){

               T data = stack1.pop();

               while (!stack2.empty()) {
                   stack1.push(stack2.pop());
               }

            return data;
        }

        return null;
    }

}
