import javax.swing.tree.TreeNode;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;


/**
 */
public class BinarySearchTree {
    private node root;


    public BinarySearchTree(){
            root=null;
    }
    public boolean empty(){
        return(root==null);
    }

    public node search(double data){
        return search(root,data);
    }
    private node search(node n, double data){
        if(n==null||n.data==data){
            return n;
        }
        if(n.data>data){
            return search(n.leftChild,data);
        }
        return search(n.rightChild,data);
    }



    public void insert(int data){
        this.root = insert(root,data);
    }
    private node insert(node root, double data) {
        node newNode = new node(data);
        if(root==null){
            return newNode;
        }
        if(root.data>data){
            root.leftChild = insert(root.leftChild,data);
        }
        else {
            root.rightChild = insert(root.rightChild,data);
        }
        return root;
    }
    public double minValue(){
        node current = root;
        while(current.leftChild!=null){
            current = current.leftChild;
        }
        return current.data;
    }
    public double maxValue(){
        node current = root;
        while(current.rightChild!=null){
            current = current.rightChild;
        }

        return current.data;
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


    private void preorder(node node){
        if(node!=null){
            System.out.println(node.data);
            preorder(node.leftChild);
            preorder(node.rightChild);
        }
    }
    public void postorder(){
        postorder(root);
    }
    private void postorder(node someNode){
        if(someNode!=null){
            postorder(someNode.leftChild);
            postorder(someNode.rightChild);
            System.out.println(someNode.data);
        }
        return;
    }
    public double even_and_and(){
        return even_and_odd(root);
    }

    private double even_and_odd(node someNode){
        if(someNode==null){
            return 0;
        }
        if(someNode.leftChild==null&&someNode.rightChild==null){
            return someNode.data%2==0 ? someNode.data : - someNode.data;
        }

        if(someNode.data%2==0){
            return even_and_odd(someNode.rightChild) + even_and_odd(someNode.leftChild) + someNode.data;
        } else {

            return even_and_odd(someNode.leftChild) + even_and_odd(someNode.rightChild) - someNode.data;
        }


    }



    public void levelOrderTraversal(){
        levelOrderTraversal(root);
    }

    private void levelOrderTraversal(node root){
        LinkedBlockingQueue<node> queue = new LinkedBlockingQueue<node>();
        queue.add(root);
        while(!queue.isEmpty()){
            node temp = queue.poll();

            System.out.println(temp.data);

            if (temp.leftChild!=null){
                queue.add(temp.leftChild);
            }
            if(temp.rightChild!=null){
                queue.add(temp.rightChild);
            }
        }
    }
    public int height(node root){
        if(root==null){
            return 0;
        }
        int right = height(root.rightChild)+1;
        int left = height(root.leftChild)+1;
        return Math.max(right,left);
    }


    public node getRoot(){
        if(root==null){
            return null;
        }else{
            return root;
        }
    }

    private void transplant(node u, node v){
        if(u.parent==null){
            root=v;
        }
        else if(u==u.parent.leftChild){
            u.parent.leftChild=v;
        }else{
            u.parent.rightChild=v;
        }
        if(v!=null){
            v.parent=u.parent;
        }
    }

    private node treeSuccessor(node x){
        if(x.rightChild!=null){
            return minimum(x.rightChild);
        }
        node parent = x.parent;
        while(parent!=null&&x==parent.rightChild){
            x=parent;
            parent=parent.parent;
        }
        return parent;
    }
    public node minimum(node x){
        node current = x;
        while(current.leftChild!=null){
            current=current.leftChild;
        }
        return current;
    }

    public node maximum(node x){
        node current = x;
        while(current.rightChild!=null){
            current=current.rightChild;
        }
        return current;
    }

    public void delete(node x){
        if(x.leftChild==null){
            transplant(x,x.leftChild);
        }else if(x.rightChild==null){
            transplant(x, x.rightChild);
        }else{
            node y = minimum(x.rightChild);
            if(y.parent!=null){
                transplant(y, y.rightChild);
                y.rightChild=x.rightChild;
                y.rightChild.parent = y;

            }
            transplant(x,y);
            y.leftChild=x.leftChild;
            y.leftChild.parent = y;
        }
    }

    public int countNodes(node root){
        if (root==null){
            return 0;
        }
        return countNodes(root.leftChild) + countNodes(root.rightChild) +1;
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

        public void setData(double data) {
            this.data = data;
        }
        public double getData(){
            return data;
        }
    }
}