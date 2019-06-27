package uptc.edu.log;

public class NodeList<T> {

    private NodeList<T> next;
    private T info;

    public NodeList(T info) {
        this.info = info;
        next = null;
    }

    public NodeList<T> getNext() {
        return next;
    }

    public void setNext(NodeList<T> next) {
        this.next = next;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

}
