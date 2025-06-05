import java.util.*;
public class MaxHeapExample{
public static void main(String[] args){
PriorityQueue<Integer> maxHeap=new PriorityQueue<>();
maxHeap.add(10);
maxHeap.add(5);
maxHeap.add(20);
maxHeap.add(3);
while(!maxHeap.isEmpty()){
System.out.println(maxHeap.poll()+" ");
}
}
}