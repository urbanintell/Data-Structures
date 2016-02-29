/**
 * Created by newuser on 2/25/16.
 */
public class SplayTree<K extends Comparable<K>> {
    node root;
    public SplayTree(){
        root=null;
    }
    public boolean empty(){
        return root ==null;
    }

    public node search(K data){
        return search(root,data);
    }
    private node search(node tree, K data){
        if(tree==null){
            return tree;
        }
        if (tree.data.compareTo(data)<0){
            return search(tree.leftChild,data);
        }
            return search(tree.rightChild,data);
    }

    public void insert(K key) {
        // splay key to root
        if (root == null) {
            root = new node(key);
            return;
        }

        root = splay(root, key);

        int cmp = key.compareTo(root.data);

        // Insert new node at root
        if (cmp < 0) {
            node n = new node(key);
            n.leftChild = root.leftChild;
            n.rightChild = root;
            root.leftChild= null;
            root = n;
        }

        // Insert new node at root
        else if (cmp > 0) {
            node n = new node(key);
            n.rightChild= root.rightChild;
            n.leftChild= root;
            root.rightChild= null;
            root = n;
        }

        // It was a duplicate key. Simply replace the value
        else if (cmp == 0) {
            root.data = key;
        }

    }

    public void inorder(){
        inorder(root);
    }
    private void inorder(node root){
        if(root!=null){
            inorder(root.leftChild);
            System.out.println(root.data);
            inorder(root.rightChild);
        }
    }


    public void preorder(){
        preorder(root);
    }
    private void preorder(node root){
        if(root!=null){
            System.out.println(root.data);
            inorder(root.leftChild);
            inorder(root.rightChild);
        }
    }


    private node splay(node h, K key) {
        if (h == null) return null;

        int cmp1 = key.compareTo(h.data);

        if (cmp1 < 0) {
            // key not in tree, so we're done
            if (h.leftChild == null) {
                return h;
            }
            int cmp2 = key.compareTo(h.leftChild.data);
            if (cmp2 < 0) {
                //zig-zig
                h.leftChild.leftChild = splay(h.leftChild.leftChild, key);
                h = rotateRight(h);
            }
            else if (cmp2 > 0) {
                //zig-zag
                h.leftChild.rightChild = splay(h.leftChild.rightChild, key);
                if (h.leftChild.rightChild != null)
                    h.leftChild = rotateLeft(h.leftChild);
            }

            if (h.leftChild == null) return h;
            else                return rotateRight(h);
        }

        else if (cmp1 > 0) {
            // key not in tree, so we're done
            if (h.rightChild == null) {
                return h;
            }

            int cmp2 = key.compareTo(h.rightChild.data);
            if (cmp2 < 0) {
                //zig-zag
                h.rightChild.leftChild  = splay(h.rightChild.leftChild, key);
                if (h.rightChild.leftChild!= null)
                    h.rightChild = rotateRight(h.rightChild);
            }
            else if (cmp2 > 0) {
                //zig-zig
                h.rightChild.rightChild = splay(h.rightChild.rightChild, key);
                h = rotateLeft(h);
            }

            if (h.rightChild == null){ return h;}
            else{                 return rotateLeft(h);}
        }

        else return h;
    }

    private node rotateRight(node h){
        node x = h.leftChild;
        h.leftChild = x.rightChild;
        x.rightChild = h;
        return x;
    }

    private node rotateLeft(node h){
        node x = h.rightChild;
        h.rightChild = x.leftChild;
        x.leftChild = h;
        return x;
    }
    class node{
        public node parent;
        public K data;
        public node leftChild;
        public node rightChild;
        public node(K data){
            this.data = data;
            leftChild=null;
            rightChild=null;
            parent=null;
        }
    }
}
