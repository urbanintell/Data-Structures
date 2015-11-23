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
        array[h(data)].insert(data);
    }

    public void delete(double data){
        array[h(data)].delete(data);
    }

    public boolean search(double data){

        return array[h(data)].search(data)==data;

    }


}
