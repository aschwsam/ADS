
public class MyLinkedList {
	
	private Node head = null;
	
	class Node {
		private int element;
		private Node next;
		
		public Node(){
			element = 0;
			next = null;
		}
		
		public Node(int element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public Node getNext(){
			
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public int getElement(){
			
			return element;
		}
	}
	
	
	public MyLinkedList(){
		head = new Node();
	}
	
	public int size(){
		int counter = 0;
		if(isEmpty()==true){
			return counter;
		} else {
			Node pastone = head;
			do{
				pastone = pastone.getNext();
				counter++;
			}while(pastone.getNext()!=null);
			return counter;
		}
	}
	
	public boolean isEmpty(){
		if(head.getNext()==null){
			return true;
		} else {
			return false;
		}
	}
	
	public void addFirst(int data){
		Node newnode = new Node(data,head.getNext());
		head.setNext(newnode);
	}
	
	public int getFirst() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			return head.getNext().getElement();
		}
	}
	
	public int removeFirst() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			int pastone = head.getNext().getElement();
			head.setNext(head.getNext().getNext());
			return pastone;
		}
	}
	
	public void addLast(int data) {
		if(isEmpty()==true){
			Node newnode = new Node(data,null);
			head.setNext(newnode);
		} else {
			Node pastone = head.getNext();
			while(pastone.getNext()!=null){
				pastone = pastone.getNext();
			}
			
			Node newnode = new Node(data, null);
			pastone.setNext(newnode);
		}

	}
	
	public int getLast() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			Node pastone = head.getNext();
			while(pastone.getNext()!=null){
				pastone = pastone.getNext();
			}
			
			return pastone.getElement();
		}
	}
	
	public int removeLast() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			Node pastone = head.getNext();
			while(pastone.getNext().getNext()!=null){
				pastone = pastone.getNext();
			}
			
			int removednode = pastone.getNext().getElement();
			pastone.setNext(null);
			return removednode;
		}
	}
	
	public void add(int index, int value) throws IndexOutOfBoundsException {
		if(index > (size()+1) || index < 0){
			throw new IndexOutOfBoundsException();
		} else {
			Node pastone = head;
			for(int i=0;i<index;i++){
				if(pastone.getNext()!=null){
					pastone = pastone.getNext();
				} else {
					throw new IndexOutOfBoundsException();
				}
			}

			Node newnode = new Node(value, pastone.getNext());
			pastone.setNext(newnode);
		}
	}
	
	public int get(int index) throws IndexOutOfBoundsException {
		System.out.println("GET");
		if(index > size() || index < 0){
			throw new IndexOutOfBoundsException();
		} else {
			Node pastone = head;
			for(int i=-1;i<index;i++){
				System.out.println(pastone.getElement());
				pastone = pastone.getNext();
			}
			System.out.println("==>"+pastone.getElement());
			return pastone.getElement();
		}
	}
	
	public int remove(int index) throws IndexOutOfBoundsException {
		System.out.println("REMOVE");
		if(index > size() || index < 0){
			throw new IndexOutOfBoundsException();
		} else {
			Node pastone = head;
			for(int i=-1;i<index;i++){
				System.out.println(pastone.getElement());
				pastone = pastone.getNext();
			}
			
			System.out.println("===>"+pastone.getElement());
			pastone.setNext(pastone.getNext());
			return pastone.getElement();
		}
	}

}
