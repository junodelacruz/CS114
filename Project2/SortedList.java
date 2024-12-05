import java.util.Iterator;

//do retrieve and search first

public class SortedList<E extends Comparable<? super E>> extends List<E> {

    public Iterator<E> iterator() {
        return new Iterator<E>() {
            public boolean hasNext() {
                return curr != null;
            }

            public E next() {
                E temp = curr.data;
                curr = curr.next;
                return temp;
            }

            private Node<E> curr = head;
        };
    }

    public void insert(E data) {
        head = insertRecursive(head, data);
    }
    private Node<E> insertRecursive(Node<E> curr, E data) {
        if(curr == null || data.compareTo(curr.data) < 0) {
            Node<E> temp = new Node<E>(data);
            temp.next = curr;
            return temp;
        }
        else {
            curr.next = insertRecursive(curr.next, data);
            return curr;
        }
    }

    public boolean search(E data) {
        return searchRecursive(head, data);
    }
    private boolean searchRecursive(Node<E> curr, E data) {
        if(curr == null) {
            return false;
        }
        if(data.compareTo(curr.data) == 0) {
            return true;
        }
        else {
            return searchRecursive(curr.next, data);
        }
    }

    public E retrieve(int index) {
        int count = 0;
        return retrieveRecursive(head, index, count);
    }
    private E retrieveRecursive(Node<E> curr, int index, int count) {
        if(curr == null) {
            return null;
        }
        if(count == index) {
            return curr.data;
        }
        else {
            return retrieveRecursive(curr.next, index, count+1);
        }
    }

    public void remove(E data) {
        head = removeRecursive(head, data);
    }
    private Node<E> removeRecursive(Node<E> curr, E data) {
        if(curr == null) {
            return null;
        }
        if(data.compareTo(curr.data) == 0) {
            return curr.next;
        }
        else {
            curr.next = removeRecursive(curr.next, data);
            return curr;
        }
    }

}