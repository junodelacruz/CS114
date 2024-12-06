package Project4;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E data){
        root = insertMethod(root, data);
    }
    public Node<E> insertMethod(Node<E> curr, E data){
        // empty curr
        if(curr == null){
            return new Node<E>(data);
        }
        // value is less
        else if(data.compareTo(curr.data) < 0){
            // recursion
            return insertMethod(curr.left, data);
        }
        // value is greater than or equal
        else {
            // recursion
            return insertMethod(curr.right, data);
        }
    }
    // public Node<E> findIOP(Node<E> curr){
    //     if(curr.right == null){
    //         return curr;
    //     }
    //     else {
    //         return findIOP(curr.right);
    //     }
    // }
    public void remove(E data){
        root = removeMethod(root, data);
    }
    public Node<E> removeMethod(Node<E> curr, E data){
        if(curr.data == data){
            // return findIOP(curr.left);
            
        }
        else if(data.compareTo(curr.data) < 0){

        }
    }
    public int search(E data){
        return 1;
    }
    public Iterator<E> iterator(){
        
    }
}