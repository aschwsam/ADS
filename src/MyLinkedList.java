public class MyLinkedList {
	
	private Node head = null;
	
	class Node {
		private Object element;
		private Node next;
		
		public Node(){
			element = null;
			next = null;
		}
		
		public Node(Object element, Node next){
			this.element = element;
			this.next = next;
		}
		
		public Node getNext(){
			
			return next;
		}
		
		public void setNext(Node next){
			this.next = next;
		}
		
		public Object getElement(){
			
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
	
	// DONE
	public boolean isEmpty(){
		if(head.getNext()==null){
			return true;
		} else {
			return false;
		}
	}
	
	public void addFirst(Object data){
		Node newnode = new Node(data,head.getNext());
		head.setNext(newnode);
	}
	
	// DONE
	public Object getFirst() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			return head.getNext().getElement();
		}
	}
	
	public Object removeFirst() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			Object pastone = head.getNext().getElement();
			head.setNext(head.getNext().getNext());
			return pastone;
		}
	}
	
	public void addLast(Object data) {
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
	
	public Object getLast() throws ListEmptyException {
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
	
	public Object removeLast() throws ListEmptyException {
		if(isEmpty()==true){
			throw new ListEmptyException();
		} else {
			Node pastone = head.getNext();
			while(pastone.getNext().getNext()!=null){
				pastone = pastone.getNext();
			}
			
			Object removednode = pastone.getNext().getElement();
			pastone.setNext(null);
			return removednode;
		}
	}
	
	public void add(int index, int value) throws IndexOutOfBoundsException {
		if(index > size() || index < size()){
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
	
	public Object get(){
		return new Object();
	}
	
	public void remove(int index) throws IndexOutOfBoundsException {
		if(index < size() || index > size()){
			throw new IndexOutOfBoundsException();
		} else {
			Node pastone = head;
			for(int i=0;i<index;i++){
				if(i>0){
					if(pastone.getNext()!=null){
						pastone = pastone.getNext();
					} else {
						throw new IndexOutOfBoundsException();
					}
				}
			}
			pastone.setNext(pastone.getNext());
		}
	}

}
