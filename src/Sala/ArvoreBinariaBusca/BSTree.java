package Sala.ArvoreBinariaBusca;

import Sala.ArvoreBinaria.BinaryTree;
import Sala.ArvoreBinaria.NodeBT;

//Classe BSTree que herda de BinaryTree
public class BSTree<T extends Comparable<T>> extends BinaryTree<T> {
	
	// Construtor
	public BSTree() {
		super();
	}
	
	@Override
	public void randomInsertion(T val){
		System.out.println("Insertion in BSTree is not random. Calling insertBST instead.");
		insertBST(val);
	}
	
	// Método de inserção específico para a BST
	public void insertBST(T val) {
		root = insertBST(root, val);
	}
	
	// Método privado para inserir recursivamente na BST
	private NodeBT<T> insertBST(NodeBT<T> node, T val) {
		// Caso base: Se o nó atual for nulo, insere aqui o novo valor
		if (node == null) {
			return new NodeBT<T>(val);
		}
		
		// Se o valor for menor que o nó atual, insere na subárvore à esquerda
		if (val.compareTo(node.getValue()) < 0) {
			node.setLeft(insertBST(node.getLeft(), val));
		}
		// Se for maior ou igual, insere na subárvore à direita
		else {
			node.setRight(insertBST(node.getRight(), val));;
		}
		
		return node; // Retorna o nó atualizado
	}
	
	// Método para remover um valor da BST
    public void removeBST(T val) {
        root = removeBST(root, val);
    }

    // Método privado que realiza a remoção recursivamente
    private NodeBT<T> removeBST(NodeBT<T> node, T val) {
        // Caso base: Se o nó é null, não há nada para remover
        if (node == null) {
            return null;
        }

        // Se o valor a ser removido é menor que o valor do nó atual, continua à esquerda
        if (val.compareTo(node.getValue()) < 0) {
            node.setLeft(removeBST(node.getLeft(), val));
        }
        // Se o valor a ser removido é maior que o valor do nó atual, continua à direita
        else if (val.compareTo(node.getValue()) > 0) {
            node.setRight(removeBST(node.getRight(), val));;
        }
        // Se o valor é igual ao valor do nó, achamos o nó a ser removido
        else {
            // Caso 1: O nó não tem filhos (nó folha)
            if (node.getLeft() == null && node.getRight() == null) {
                return null; // Remove o nó retornando null
            }
            // Caso 2: O nó tem apenas um filho (esquerda ou direita)
            else if (node.getLeft() == null) {
                return node.getRight(); // Retorna o filho direito para substituir o nó
            } else if (node.getRight() == null) {
                return node.getLeft(); // Retorna o filho esquerdo para substituir o nó
            }
            // Caso 3: O nó tem dois filhos
            else {
                // Encontra o menor valor na subárvore direita (ou maior na esquerda)
                T minValue = min(node.getRight());
                node.setValue(minValue); // Substitui o valor do nó pelo menor valor
                // Remove o nó que continha o menor valor na subárvore direita
                node.setRight(removeBST(node.getRight(), minValue));;
            }
        }
        return node; // Retorna o nó atualizado
    }

    // Método para encontrar o menor valor na árvore (implementado anteriormente)
    public T min() {
        if (root == null)
            return null;
        return min(root);
    }

    // Método privado para encontrar o menor valor a partir de um nó
    private T min(NodeBT<T> n) {
        if (n.getLeft() == null)
            return n.getValue();
        return min(n.getLeft());
    }
}
