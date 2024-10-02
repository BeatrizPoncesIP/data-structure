package Sala.ArvoreBinaria;

import java.util.Random;

public class BinaryTree<T> {
	
	protected NodeBT<T> root;
	private static Random rand = new Random();

	public NodeBT<T> getRoot(){
		return root;
	}
	
	public BinaryTree() {
		this.root = null;
	}
	
	public void randomInsertion(T val) {
		
		boolean inserted = false; // Guarda se fizemos a inserção
		
		// Raiz nula
		if (root == null) {
			root = new NodeBT<T>(val);
		}
		
		// Raiz não nula
		else {
			NodeBT<T> aux = root;
			// Percorre enquanto não encontra a posição de inserção
			while(!inserted) {
				// Se próximo boolean for verdadeiro, procura à esquerda
				if(rand.nextBoolean()) {
					// Se nó à esquerda for nulo, insere
					if(aux.getLeft() == null) {
						aux.setLeft(new NodeBT<T>(val));
						inserted = true;
					}
					// Senão: se nó à esquerda não for nulo
					else {
						aux = aux.getLeft();
					}
				}
				// Senão: desço à direita
				else {
					// Se nó à direita for nulo, insere
					if(aux.getRight() == null) {
						aux.setRight(new NodeBT<T>(val));
						inserted = true;
					}
					// Senão: se nó à direita não for nulo
					else {
						aux = aux.getRight();
					}
				}
			}
		}	
	}
	
	public boolean search(T val) {
		return search(root, val);
	}
	
	private boolean search(NodeBT<T> node, T val) {
		// Se o nó for nulo, o valor não está aqui
		if (node == null) 
			return false;
		
		// Se o valor estiver no nó, retorna verdadeiro
		if(node.getValue().equals(val))
			return true;
		
		// Busca à esquerda
		if(search(node.getLeft(), val))
			return true;
		
		// Busca à direita
		if(search(node.getRight(), val))
			return true;
		
		return false;
	}
	
	public String toString() {
		StringBuilder out = new StringBuilder();
		if (root == null) {
			out.append("<null>\n");
		}
		else {
			toString(root.getRight(), "", false, out);
			out.append(root.getValue().toString() + "\n");
			toString(root.getLeft(),"", true, out);
			out.append("\n");
		}
		return out.toString();
	}
	private void toString(NodeBT<T> node, String prefix, boolean leftChild, StringBuilder out) {
		if (node == null)
			return;
		
		if(leftChild) {
			toString(node.getRight(), prefix + "| ", false, out);
			out.append(prefix + "|>" + node.getValue().toString() + "\n");
			toString(node.getLeft(), prefix + "  ", true, out);
		}
		else {
			toString(node.getRight(), prefix + "  ", false, out);
			out.append(prefix + "|>" + node.getValue().toString() + "\n");
			toString(node.getLeft(), prefix + "| ", true, out);
		}
	}
	
	
}