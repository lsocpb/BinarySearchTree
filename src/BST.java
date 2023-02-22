

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
public class BST {

     public Node root;

    public BST(){
        root = null;
    }

    public void insert(int key){ // publiczna metoda wywołuje metode prywatną insertRec

        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key){ // wstawienie nowego węzła z kluczem key
        if(root == null){ //jezeli korzeń jest pusty to robimy nowy węzeł  z kluczem key i ustawiamy go jako korzeń
            root = new Node(key);
            return root;
        }
        if(key < root.key) // jezeli klucz jest mniejszy niz klucz korzenia to rekurencyjnie dla lewego podrzewa
            root.left = insertRec(root.left, key);
        else if (key > root.key) // jezeli klucz jest wiekszy to dla prawego
            root.right = insertRec(root.right, key);

        return root;
    }

    public void deleteKey(int key){
        root = deleteRec(root, key);
    }

    private Node deleteRec(Node root, int key){ // usuwamy wezeł z kluczem key
        if(root == null) // jezeli korzeń jest pusty
            return root;
        if(key < root.key) // jezeli klucz jest mniejszy niz klucz korzenia rekurencja dla lewgo poddrzewa
           root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key); // jezeli jest wiekszy
        else{ // jezeli jest rowny
            if(root.left == null) //jezeli nie ma lewego zwraca null
                return root.right;
            else if(root.right == null) // jezeli nie ma prawego zwraca null
                return root.left;
            root.key = minValue(root.right); // jezeli ma i lewe i prawe to szuka najmniejszego w prawym poddrzewie
            root.right = deleteRec(root.right, root.key); // i usuwa
        }
        return root;
    }
    int minValue(Node root){ // znajduje najmniejszy klucz w drzewie BST zaczynajac od wezła root
        int minv = root.key;
        while(root.left != null){
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    public List<Integer> levelOrderTraversalToList() { //testing method
        List<Integer> resultList = new ArrayList<>();
        if (root == null) {
            return resultList;
        }

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);

        while (!nodeQueue.isEmpty()) {
            Node current = nodeQueue.poll();
            resultList.add(current.key);

            if (current.left != null) {
                nodeQueue.offer(current.left);
            }
            if (current.right != null) {
                nodeQueue.offer(current.right);
            }
        }

        return resultList;
    }
}
