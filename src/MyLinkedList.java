
public class MyLinkedList {
	
	private Node head;
	
	class Node{
		private int value;
		private Node next;
		
		public Node(int value){
			this.value = value;
			next = null;
		}
		
		public Node(Node position, int value){
			this.value = value;
			next = position;
		}
		
		public Node getPointer(){
			return next;
		}
		
		public void setPointer(Node next){
			this.next = next;
		}
		
		public int getValue(){
			return value;
		}
	}
	
	public MyLinkedList(){
		head = new Node(0);
	}
	
	public int size(){
		Node currentnode = head;
		int counter = 1;
		
		while(currentnode.getPointer()!=null){
			currentnode = currentnode.getPointer();
			counter++;
		}
		
		return counter;
	}
	
	public int getFirst(){
		return head.getValue();
	}
	
	public int get(int position){
		Node currentnode = head;
		
		for(int i=0;i<position;i++){
			currentnode=currentnode.getPointer();
		}

		return currentnode.getValue();
	}
	
	public void addFirst(int value){
		head.setPointer(new Node(value));
	}
	
	public void add(int position, int value){
		Node currentnode = head;
		
		// Loop through nodes until we reach our position to add the new node
		for(int i=0;i<position;i++){
			if(currentnode.getPointer()!=null){
				currentnode = currentnode.getPointer();
			} else {
				currentnode = currentnode.getPointer();
				break;
			}
		}
		
		Node newnode = new Node(value);
		newnode.setPointer(currentnode.getPointer());
		currentnode.setPointer(newnode);
	}
	
	public void addLast(int value){
		Node currentnode = head.getPointer();
		
		while(currentnode.getPointer()!=null){
			currentnode = currentnode.getPointer();
		}
		
		currentnode.setPointer(new Node(value));
	}
	
	public int getLast(){
		Node currentnode = head.getPointer();
		
		while(currentnode.getPointer()!=null){
			currentnode = currentnode.getPointer();
		}
		return currentnode.getValue();
	}
	
	public void removeFirst(){
		if(head.getPointer()!=null){
			head = head.getPointer();
		}
	}
	
	public void remove(int position){
		Node currentnode = head;
		
		for(int i=0;i<position;i++){
			if(currentnode.getPointer()==null){
				System.out.println("Node is out of ranche");
				break;
			} else {
				currentnode = currentnode.getPointer();
			}
		}
		
		// One below target
		if(currentnode.getPointer()==null){
			currentnode.setPointer(null);
		} else {
			if(currentnode.getPointer().getPointer()==null){
				currentnode.setPointer(null);
			} else {
				currentnode.setPointer(currentnode.getPointer().getPointer());
			}
		}
		
	}
	
	public void removeLast(){
		Node currentnode = head;
		
		while(currentnode.getPointer()!=null){
			if(currentnode.getPointer()==null){
				break;
			} else {
				currentnode = currentnode.getPointer();
			}
		}
		currentnode.setPointer(null);
	}
	


}
