import java.util.ArrayList;
import java.util.List;

/**
 * Created by newuser on 2/4/16.
 */
public class Driver {
        public static void main(String[] args) {
            SplayTree<Integer> tree = new SplayTree<Integer>();
            tree.insert(4);
            tree.insert(2);
            tree.insert(3);
            tree.insert(1);
//            tree.insert(8);
//            tree.insert(5);
//            tree.insert(9);
//            tree.insert(7);
            tree.preorder();
            node n = tree.search(4);

        }
}
