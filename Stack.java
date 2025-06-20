class Node{
int data;
Node next;
Node(int data){
	this.data=data;
	this.next=null;
}
}
class Stack{
private Node top;
public Stack(){
this.top=null;
}
public void push(int data){
Node newNode=new Node(data);
newNode.next=top;
top=newNode;
}
public int pop(){
if(isEmpty()){
System.out.println("Stack Underflow!Cannot pop from an empty stack");
return-1;
}
int poppedData=top.data;
top=top.next;
return poppedData;
}
public int peek(){
if(isEmpty()){
System.out.println("Stack is empty!");
return-1;
}
return top.data;
}
public boolean isEmpty(){
return top==null;
}
public void display(){
if(isEmpty()){
System.out.println("Stack is empty!");
return;
}
Node temp=top;
while(temp!=null){
System.out.print(temp.data+"->");
temp=temp.next;
}
System.out.println("None");
}
} 
public class Main{
	public static void main(String[] args){
		Stack stack=new Stack();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.display();
		System.out.println("Popped: " + stack.pop());
		System.out.println("Top element: " + stack.peek());
		stack.display();
	}
}