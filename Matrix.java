import java.util.Arrays;
public class Main{
public static void addEdge(int[][] mat,int i,int j){
mat[i][j]=1;
mat[i][j]=1;
}
public static void displayMatrix(int[][] mat){
for(int[] row:mat){
for(int val:row){
System.out.println(val+"");
}
System.out.println();
}
}
public static void Matrix(String[] args){
int V=4;
int[][] mat=new int[V][V];
addEdge(mat,0,1);
addEdge(mat,0,2);
addEdge(mat,1,2);
addEdge(mat,2,3);
int[][] mat={{0,1,0,0},
           {1,0,1,0},
		   {0,1,0,1},
		   {0,0,1,0}};
System.out.println("Adjacency Matrix Representation");
display matrix(Mat);
}
}