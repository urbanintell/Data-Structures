/**
 * Created by newuser on 11/23/15.
 */
public class BinarySearchTree {

    node root;


    public static void main(String[] args) {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(2);
        tree.insert(1);
        tree.insert(3);

        System.out.println(tree.search(6));
    }

    public BinarySearchTree(){
            root=null;
    }

    public boolean empty(){
        return(root==null);
    }

    public boolean search(double data){

        if (empty()){
            return false;
        }else{
            for(node current = root; current!=null; ){
            if(current.data == data){
                return true;
            }
            else if(current.data>data){
                current = current.leftChild;
            }else {
                current = current.rightChild;
            }

            }
        }
        return false;
    }

    public void insert(double data){

        node newnode = new node(data);
        if (empty()){
            root = new node(data);
        }else{
            node current = root;
            node parent= root;
        while(current!=null){
            parent = current;
            if(current.data==data){
                current =  current.rightChild;
            }else if(current.data > data){
                current = current.leftChild;
            }else{
                current= current.rightChild;
            }

         }
            newnode.parent = parent;
            if(parent==null){
                root=parent;
            }
            else if(newnode.data==root.data){
                root.rightChild = newnode;
            }else if(newnode.data > root.data){
                root.rightChild = newnode;
            }else{
                root.leftChild = newnode;
            }

        }

    }




    public void inorder(){
        inorder(root);
    }
    public void inorder(node node){
        if(node!=null){
            inorder(node.leftChild);
            System.out.println(node.data);
            inorder(node.rightChild);
        }
    }



    public void preorder(){
        preorder(root);
    }
    public void preorder(node node){
        if(node!=null){
            System.out.println(node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }

    }
    public void postorder(){
        postorder(root);
    }
    public void postorder(node node){
        if(node!=null){
            preorder(node.leftChild);
            preorder(node.rightChild);
            System.out.println(node.data);

        }
    }

    public class node{
        double data;
        node parent;
        node leftChild;
        node rightChild;
        public node(double data){
            this.data = data;
            parent = null;
            leftChild=null;
            rightChild=null;
        }
    }
}
