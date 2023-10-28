import java.util.*;

class Node<T> {
    public T value;
    public Node<T> next, prev;

    public Node(T _value) {
        value = _value;
        next = null;
        prev = null;
    }
}

public class OrderedList<T> {
    public Node<T> head, tail;
    private boolean _ascending;
    private int listSize;

    public OrderedList(boolean asc) {
        head = null;
        tail = null;
        _ascending = asc;
        listSize = 0;
    }

    private void addInTail(Node<T> _item) {
        if (head == null) {
            this.head = _item;
            this.head.next = null;
            this.head.prev = null;
        } else {
            this.tail.next = _item;
            _item.prev = tail;
        }
        this.tail = _item;
        listSize++;
    }

    private void addInHead(Node<T> _item) {
        Node<T> tmp = this.head;
        this.head = _item;
        _item.next = tmp;
        if (tmp != null) {
            tmp.prev = _item;
        }
        if (listSize == 0) {
            this.tail = _item;
        }
        listSize++;
    }

    private void insertAfter(Node<T> _nodeAfter, Node<T> _nodeToInsert) {
        if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
        } else {
            if (_nodeToInsert != null) {
                Node<T> after = find(_nodeAfter.value);
                if (after != null) {
                    Node<T> next = after.next;
                    after.next = _nodeToInsert;
                    _nodeToInsert.prev = after;
                    _nodeToInsert.next = next;
                    if (next != null) {
                        next.prev = _nodeToInsert;
                    }
                    if (_nodeToInsert.next == null) {
                        this.tail = _nodeToInsert;
                    }
                    listSize++;
                } else {
                    addInHead(_nodeToInsert);
                }
            }
        }
    }

    public int compare(T v1, T v2) {
        if ((int) v1 == (int) v2) return 0;
        if (this._ascending && (int) v1 < (int) v2) {
            return -1;
        } else if (!this._ascending && (int) v1 > (int) v2) {
            return -1;
        }
        return 1;
    }

    public void add(T value) {
        if (this.head == null) addInHead(new Node<>(value));
        if (this._ascending && compare(value, this.tail.value) == 1) addInTail(new Node<>(value));
        if (!this._ascending && compare(value, this.head.value) == 1) addInHead(new Node<>(value));

        Node<T> node = this.head;
        while (node != null) {
            if (this._ascending && compare(node.value, value) == 1) {
                insertAfter(node, new Node<>(value));
            } else if (!this._ascending && compare(node.value, value) == 1) {
                insertAfter(node.prev, new Node<>(value));
            }
            node = node.next;
        }

    }

    public Node<T> find(T val) {
        Node<T> node = this.head;
        while (node != null) {
            if (node.value == val)
                return node;
            node = node.next;
        }
        return null;
    }

    public void delete(T val) {
        Node<T> node = find(val);
        node.prev.next = node.next;
        node.prev = null;
        node.next = null;
        listSize--;

    }

    public void clear(boolean asc) {
        _ascending = asc;
        Node<T> node = this.head;
        Node<T> next = node.next;
        while (next != null) {
            node.next = null;
            node.prev = null;
            node = next;
            next = node.next;
        }
        this.head = null;
        this.tail = null;

        listSize = 0;
    }

    public int count() {
        return listSize;
    }

    ArrayList<Node<T>> getAll() {
        ArrayList<Node<T>> r = new ArrayList<Node<T>>();
        Node<T> node = head;
        while (node != null) {
            r.add(node);
            node = node.next;
        }
        return r;
    }
}