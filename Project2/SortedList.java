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
        Node<E> curr = head;
        if() {

        }
        else {

            insert(data);
        }
    }

    public void remove(E data) {
        
    }

    int count = 0;
    public E retrieve(int index) {
        Node<E> curr = head;
        if(count == index)
        {
            return curr.data;
        }
        else
        {
            curr = curr.next;
            head = curr;
            count++;
            retrieve(index);
        }
        return null;
    }

    public boolean search(E data) {
        Node<E> curr = head;
        if(curr.data == data) {
            return true;
        }
        else {
            curr = curr.next;
            head = curr;
            search(data);
        }
        return false;
    }
}