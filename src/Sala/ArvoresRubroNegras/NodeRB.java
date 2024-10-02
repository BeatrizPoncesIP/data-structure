package Sala.ArvoresRubroNegras;

// Classe NodeRB representando um nó de uma árvore rubro-negra
public class NodeRB<T> {
    T info;                 // Valor armazenado no nó
    NodeRB<T> left;         // Referência para o nó filho à esquerda
    NodeRB<T> right;        // Referência para o nó filho à direita
    boolean isRed;          // Indica a cor do nó (true para vermelho, false para preto)

    // Construtor para criar um nó com o valor fornecido
    public NodeRB(T info) {
        this.info = info;   // Define o valor do nó
        this.isRed = true;  // Nós novos são sempre vermelhos inicialmente
    }

    // Construtor para criar um nó com valor e filhos especificados
    public NodeRB(T info, NodeRB<T> left, NodeRB<T> right) {
        this.info = info;       // Define o valor do nó
        this.left = left;       // Define o filho à esquerda
        this.right = right;     // Define o filho à direita
        this.isRed = true;      // Nós novos são sempre vermelhos inicialmente
    }
}