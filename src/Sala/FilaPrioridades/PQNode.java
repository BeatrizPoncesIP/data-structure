package Sala.FilaPrioridades;

public class PQNode<T> {
	T value;
	int priority;
	PQNode<T> next;
	
	public PQNode() {
		this(null, -1 , null);
	}
	
	public PQNode(T value, int priority, PQNode<T> next) {
		this.value = value;
		this.next = next;
		this.priority = priority;
	}
	
	public PQNode(T value, int priority) {
		this(value, priority, null);
	}
}