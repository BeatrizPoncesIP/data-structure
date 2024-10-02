package Sala.ArvoreBinaria;

public class NodeBT<T> {
	private T value;
	private NodeBT<T> left; // Referência para o filho da esquerda
	private NodeBT<T> right; // Referência para filho da direita

	public NodeBT() {
		this.value = null;
		this.left = null;
		this.right = null;
	}
	
	public NodeBT(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public NodeBT(T value, NodeBT<T> left, NodeBT<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public NodeBT<T> getLeft() {
		return left;
	}

	public NodeBT<T> getRight() {
		return right;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setLeft(NodeBT<T> left) {
		this.left = left;
	}

	public void setRight(NodeBT<T> right) {
		this.right = right;
	}
}

