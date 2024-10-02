package Sala.FilaPrioridades;

public class LinkedPriorityQueue<T> {
	PQNode<T> head;
	int size;
	
	public LinkedPriorityQueue() {
		this.head = null;
		this.size = 0;
	}
	
	public LinkedPriorityQueue(PQNode<T> node) {
		this.head = node;
		this.size = 1;
	}
	
	// Computational cost: O(n)
	public boolean insert(T value, int priority) {
		PQNode<T> newNode = new PQNode<T>(value, priority);
		// If the queue is empty
		if (this.head == null) {
			this.head = newNode;
		}
		// If the queue has elements, we want to insert in order
		else {
			PQNode<T> aux = head;
			// If we must insert in the first position
			if(newNode.priority > head.priority) {
				newNode.next = head;
				head = newNode;
			}
			else {
				while(aux.next != null && 
					  aux.next.priority >= newNode.priority)
					aux = aux.next;
				newNode.next = aux.next;
				aux.next = newNode;
			}
			
		}
		size++;
		return true;
	}
	
	// Computational cost: O(1)
	public T removeMax() {
		if(head == null)
			return null;
		else {
			PQNode<T> aux = head;
			head = head.next;
			size--;
			return aux.value;
		}
	}
	
	// O(1)
	public T max() {
		if(head == null)
			return null;
		else
			return head.value;
	}
	
	public void printList() {
		PQNode<T> aux = head;
		while(aux != null) {
			System.out.println("Value: " + aux.value + " - Priority: " + aux.priority);
			aux = aux.next;
		}
	}
	
	
}