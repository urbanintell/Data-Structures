import java.util.concurrent.LinkedBlockingDeque;

/**
 * Created by newuser on 11/23/15.
 */
public class HashTable {
     LinkedList array[];

    public HashTable(int size){
        array = new LinkedList[size];
      }

 
    public int h(double data){
        return (int)((Math.pow(data,2)) % array.length) ;
    }

    public void insert(double data){
    if (array[h(data)] !=null) {
        array[h(data)].insert(data);
    }else{
        array[h(data)] = new LinkedList();
    }
    }

    public void delete(double data){
        if ( array[h(data)]!=null) {
            array[h(data)].delete(data);
        }else{
            return;
        }
    }

    public boolean search(double data){

        return  (array[h(data)]!=null) && array[h(data)].search(data)==data;

    }


}
