/**
 * Created by newuser on 2/27/16.
 */
public class Graph {
    private int[][] matrix;
    private int size;
    public Graph(int size){
        this.size=size;
        matrix = new int[size][size];
    }
    public void addEdge(int v, int w){
        matrix[v][w]+=1;
    }
    public void addVertex(int v){
        ++size;
        int newMatrix[][] = new int[size][size];
        for(int i=0;i<matrix.length;i++){
            for(int k=0;k<matrix.length;k++){
                newMatrix[i][k] = matrix[i][k];
            }
        }
        matrix = newMatrix;
    }
    public void removeVertex(int v){

    }
    public void removeEdge(int v, int w){
        matrix[v][w]=0;
    }
    public void reduceWeight(int v,int w){
        if(matrix[v][w]!=0) {
            matrix[v][w] -= 1;
        }
        return;
    }
}
