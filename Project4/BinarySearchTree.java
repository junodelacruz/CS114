package Project4;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E data){
        root = insertMethod(root, data);
    }
    public E insertMethod(Node<E> curr, E data){
        if(curr == null){
            return data;
        }
        
    }
    public void remove(E data){
               
    }
    public int search(E data){
               
    }
    public Iterator<E> iterator(){

    }
}