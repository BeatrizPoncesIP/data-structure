package Sala.ArvoresRubroNegras;

public class RBTree<T extends Comparable<T>> {

    private NodeRB<T> root; // Nó raiz da árvore rubro-negra
    private int size;       // Mantém o controle do tamanho da árvore

    // Método de rotação à esquerda
    private NodeRB<T> rotLeft(NodeRB<T> h) {
        NodeRB<T> x = h.right;     // O filho à direita de h se torna o novo pai
        h.right = x.left;          // O filho à esquerda de x se torna o filho à direita de h
        x.left = h;                // h se torna o filho à esquerda de x
        x.isRed = h.isRed;         // x herda a cor de h
        h.isRed = true;            // h se torna vermelho
        return x;                  // Retorna o novo nó raiz da subárvore
    }

    // Método de rotação à direita
    private NodeRB<T> rotRight(NodeRB<T> h) {
        NodeRB<T> x = h.left;      // O filho à esquerda de h se torna o novo pai
        h.left = x.right;          // O filho à direita de x se torna o filho à esquerda de h
        x.right = h;               // h se torna o filho à direita de x
        x.isRed = h.isRed;         // x herda a cor de h
        h.isRed = true;            // h se torna vermelho
        return x;                  // Retorna o novo nó raiz da subárvore
    }

    // Método para inverter as cores de um nó e seus filhos
    private void invertColors(NodeRB<T> h) {
        h.isRed = !h.isRed;           // Inverte a cor do nó atual
        h.left.isRed = !h.left.isRed; // Inverte a cor do filho à esquerda
        h.right.isRed = !h.right.isRed; // Inverte a cor do filho à direita
    }

    // Verifica se um nó é vermelho
    private boolean isRed(NodeRB<T> node) {
        if (node == null) {
            return false; // Nulo é considerado preto
        }
        return node.isRed; // Retorna true se o nó for vermelho
    }

    // Calcula a altura da árvore
    private int height(NodeRB<T> n) {
        if (n == null) {
            return -1; // Árvore vazia tem altura -1
        }
        int leftHeight = height(n.left); // Altura da subárvore esquerda
        int rightHeight = height(n.right); // Altura da subárvore direita
        return 1 + Math.max(leftHeight, rightHeight); // Altura é 1 mais a maior altura entre as subárvores
    }

    // Método público para inserir um valor na árvore
    public void put(T value) {
        root = put(root, value);    // Insere o valor começando na raiz
        root.isRed = false;         // A raiz deve sempre ser preta após a inserção
    }

    // Método interno recursivo para lidar com a inserção e o reequilíbrio
    private NodeRB<T> put(NodeRB<T> n, T value) {
        if (n == null) {
            size++; // Incrementa o tamanho da árvore
            return new NodeRB<>(value); // Cria um novo nó vermelho
        }

        int comp = value.compareTo(n.info); // Compara o valor a ser inserido com o nó atual
        if (comp == 0) {
            n.info = value; // Atualiza o valor se for igual
        } else if (comp < 0) {
            n.left = put(n.left, value); // Insere na subárvore esquerda
        } else {
            n.right = put(n.right, value); // Insere na subárvore direita
        }

        // Balanceando a árvore com rotações e recolorimento
        if (isRed(n.right) && !isRed(n.left)) {
            n = rotLeft(n); // Corrige o caso de filho direito vermelho e filho esquerdo preto
        }
        if (isRed(n.left) && isRed(n.left.left)) {
            n = rotRight(n); // Corrige o caso de dois filhos esquerdos vermelhos
        }
        if (isRed(n.left) && isRed(n.right)) {
            invertColors(n); // Corrige o caso de dois filhos vermelhos
        }

        return n; // Retorna o nó ajustado
    }

    // Obtém o tamanho da árvore
    public int size() {
        return size; // Retorna o número de nós na árvore
    }

    // Obtém a altura da árvore
    public int height() {
        return height(root); // Calcula a altura a partir da raiz
    }

    // Método público para verificar se a árvore está vazia
    public boolean isEmpty() {
        return root == null; // Retorna true se a raiz for nula
    }
}