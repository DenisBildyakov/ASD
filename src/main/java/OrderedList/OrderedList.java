package OrderedList;

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
                Node<T> after = _nodeAfter;
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
        int i = 0;
        if (v1 instanceof Number && v2 instanceof Number) {
            i = Integer.compare((int) v1, (int) v2);
        }
        if (v1 instanceof String && v2 instanceof String) {
            i = ((String) v1).compareTo((String) v2);
        }
        if (i < 0) return -1;
        if (i > 0) return 1;
        return i;
    }

    public void add(T value) {
        if (this.head == null) {
            addInHead(new Node<>(value));
            return;
        }
        if (this._ascending && compare(value, this.tail.value) >= 0) {
            addInTail(new Node<>(value));
            return;
        }
        if (!this._ascending && compare(value, this.head.value) >= 0) {
            addInHead(new Node<>(value));
            return;
        }
        if (this._ascending && compare(value, this.head.value) == -1) {
            addInHead(new Node<>(value));
            return;
        }
        if (!this._ascending && compare(value, this.tail.value) == -1) {
            addInTail(new Node<>(value));
            return;
        }
        if (this._ascending) {
            Node<T> insertAfterNode = findLatest(value);
            insertAfter(insertAfterNode, new Node<>(value));
        }
        if (!this._ascending) {
            Node<T> insertAfterNode = findFirst(value);
            insertAfter(insertAfterNode.prev, new Node<>(value));
        }
    }

    public Node<T> find(T val) {
        if (this._ascending && compare(val, this.tail.value) == 1) {
            return null;
        }
        if (!this._ascending && compare(val, this.head.value) == 1) {
            return null;
        }
        Node<T> node = this.head;
        while (node != null) {
            if (node.value == val)
                return node;
            node = node.next;
        }
        return null;
    }

    private Node<T> findFirst(T val) {
        if (this._ascending && compare(val, this.tail.value) == 1) {
            return null;
        }
        if (!this._ascending && compare(val, this.head.value) == 1) {
            return null;
        }
        Node<T> node = this.head;
        while (node != null) {
            if (compare(val, node.value) >= 0)
                return node;
            node = node.next;
        }
        return null;
    }

    private Node<T> findLatest(T val) {
        Node<T> nodeToFind = null;
        if (this._ascending && compare(val, this.tail.value) >= 0) {
            return this.tail;
        }
        if (!this._ascending && compare(val, this.head.value) >= 0) {
            return this.head;
        }
        Node<T> node = this.head;
        while (node != null) {
            if (compare(val, node.value) >= 0) {
                nodeToFind = node;
            }
            node = node.next;
        }
        return nodeToFind;
    }

    public void delete(T val) {
        Node<T> node = this.head;
        Node<T> prev = null;
        while (node != null) {
            if (node.value == val) {
                if (prev == null) {
                    this.head = node.next;
                    if (this.head != null) {
                        this.head.prev = null;
                    }
                    node.next = null;
                    node.prev = null;
                    listSize--;
                    if (listSize == 0) {
                        this.tail = null;
                    }
                    return;
                }
                if (node.next == null) {
                    Node<T> toDelete = this.tail;
                    this.tail = prev;
                    this.tail.next = null;
                    toDelete.prev = null;
                    listSize--;
                    return;
                }
                Node<T> next = node.next;
                prev.next = next;
                next.prev = prev;
                node.next = null;
                node.prev = null;
                listSize--;
                return;
            }
            prev = node;
            node = node.next;
        }
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