package lista03;

import Sala.ArvoreBinaria.*;
import Sala.ArvoreBinariaBusca.*;

public class ex7 {
    
    // public static boolean isBalanced(BSTree<T> arvore){
    //     if (arvore.getRoot()==null){
    //         return true;
    //     } else if(isBalanced(arvore.getRoot().getLeft()) == isBalanced(arvore.getRoot().getRight())){
    //         return true;
    //     }
    //     return false;
    // }

    // private static int isBalanced(NodeBT<T> node){
    //     if(isBalanced(node.getLeft())!=null){
    //         return 1 + isBalanced(node.getLeft);
    //     } else if(isBalanced(node.getRight())!=null){
    //         return 1 + isBalanced(node.getRight);
    //     }
    //     return 0;
    // }

    public int height(BSTree<T> arvore){
        return height(arvore.getRoot);
    }

    private int height(NodeBT<T> node){
        if (node == null){
            return -1;
        }
        return 1 + Math.max(height(node.getLeft), height(node.getRight));
    }

    public boolean isBalanced(BSTree<T> arvore) {
        return isBalanced(arvore.getRoot);
    }

    public boolean isBalanced(NodeBT<T> node){
        if(node == null){
            return true;
        }

        int leftHeight = height(node.getLeft());
        int rightHeight = height(node.getRight());

        if(Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        return isBalanced(node.getLeft()) && isBalanced(node.getRight());
    }
}
