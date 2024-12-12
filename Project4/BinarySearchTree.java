package Project4;

import java.util.Iterator;
import java.util.Vector;

public class BinarySearchTree<E extends Comparable<? super E>> extends BinaryTree<E> {
    public void insert(E data) {
        root = insertMethod(root, data);
    }

    public Node<E> insertMethod(Node<E> curr, E data) {
        // empty curr
        if (curr == null) {
            return new Node<E>(data);
        }
        // value is less
        else if (data.compareTo(curr.data) < 0) {
            // recursion
            return insertMethod(curr.left, data);
        }
        // value is greater than or equal
        else {
            // recursion
            return insertMethod(curr.right, data);
        }
    }

    private Node<E> findMax(Node<E> curr) {
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }

    public void remove(E data) {
        root = removeMethod(root, data);
    }

    private Node<E> removeMethod(Node<E> curr, E data) {
        if (curr == null) {
            return null;
        }

        if (data.compareTo(curr.data) < 0) {
            curr.left = removeMethod(curr.left, data);
        } else if (data.compareTo(curr.data) > 0) {
            curr.right = removeMethod(curr.right, data);
        } else {
            if (curr.left == null) {
                return curr.right;
            } else if (curr.right == null) {
                return curr.left;
            }
            Node<E> iop = findMax(curr.left);
            curr.data = iop.data;
            curr.left = removeMethod(curr.left, iop.data);
        }
        return curr;
    }

    public int search(E data) {
        return searchMethod(root, data) != null ? 1 : 0;
    }
    
    private Node<E> searchMethod(Node<E> curr, E data) {
        if (curr == null || curr.data.equals(data)) {
            return curr;
        }
        if (data.compareTo(curr.data) < 0) {
            return searchMethod(curr.left, data);
        } else {
            return searchMethod(curr.right, data);
        }
    }

    public Iterator<E> iterator() {
        vector = new Vector<E>();
        traverse(root);
        return vector.iterator();
    }

    private void traverse(Node<E> curr) {
        if (curr != null) {
            traverse(curr.left);
            vector.add(curr.data);
            traverse(curr.right);
        }
    }

    private Vector<E> vector;
}