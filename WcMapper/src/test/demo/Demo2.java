package test.demo;



class Node{
	String  name;
	String  ip;
	Node next;
}
public class Demo2 {
	public static void main(String[] args) {
		Node node1=new Node();
		node1.name="zz";
		node1.ip="192.168.0.1";
		node1.next=null;
		Node node2=new Node();
		node2.name="xx";
		node2.ip="192.168.0.2";
		node2.next=null;
		NodeLinkList nl=null;
		try {
			nl = new NodeLinkList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nl.addNode(node1);
		nl.addNode(node2);
		System.out.println(nl.length);
		nl.getLast();
		//nl.allNode();
		nl.deleteNode(node2);
		System.out.println(nl.length);
		nl.getLast();
		
		
	}
}
class NodeLinkList{
	
	int length;
	Node first;
	Node last;
	NodeLinkList() {
		// TODO Auto-generated constructor stub
		Node node=new Node();
		node.name="root";
		node.ip="0.0.0.0";
		node.next=null;
		first=node;
		length=1;
		
		last=node;	

	}
	public void addNode(Node node){
		length+=1;
		last.next=node;
		last=node;
	}
	public void getLast(){
		System.out.println(last.name);
	}
	public void allNode(){
		Node n1=new Node();
		n1=first;
		for(int i=0;i<length;i++){
				System.out.println(n1.name);
				n1=n1.next;
		}
	}
	public Node findNode(Node node){	
		Node n1=first;
		for(int i=0;i<length;i++){
				if (n1.next.name.equals(node.name)) {
					return n1.next;
				}
				n1=n1.next;
		}
		return null;
	}
	public void deleteNode(Node node){
		Node n1=first;
		for(int i=0;i<length-1;i++){
			if (i<length-2) {
				if (n1.next.name.equals(node.name)) {
					n1.next=n1.next.next;
				}
				n1=n1.next;
			}else{
				if (n1.next.name.equals(node.name)) {
					last=n1;
					n1.next=null;
					length=length-1;
				}else{
					
				}
				
			}
				
		}
	}
	
//	public Node findNode(Node node){
//		
//	}
}
