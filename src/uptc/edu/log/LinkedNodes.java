package uptc.edu.log;

public class LinkedNodes<T> {

    NodeList<T> head;

    public LinkedNodes() {
        head = null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void addBegin(T info) {
        if (isEmpty()) {
            head = new NodeList<>(info);
        } else {
            NodeList<T> newNode = new NodeList<>(info);
            newNode.setNext(head);
            head = newNode;
        }
    }

    public void addEnd(T info) {
        if (isEmpty()) {
            head = new NodeList<>(info);
        } else {
            NodeList<T> newNode = new NodeList<>(info);
            NodeList<T> aux = head;
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newNode);
        }
    }

    public T pop() {
        T node = head.getInfo();
        head = head.getNext();
        return node;
    }

}
