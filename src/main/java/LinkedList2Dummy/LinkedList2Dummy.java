package LinkedList2Dummy;

import java.util.ArrayList;

public class LinkedList2Dummy {
    private final Node dummy;

    private int listSize;

    public LinkedList2Dummy() {
        this.dummy = new Node(Integer.MIN_VALUE);
        this.dummy.next = null;
        this.dummy.prev = null;
        listSize = 0;
    }

    public Node getHead() {
        return listSize == 0 ? null : this.dummy.next;
    }

    public Node getTail() {
        return listSize == 0 ? null : this.dummy.prev;
    }

    public void addInTail(Node _item) {
        Node tail = getTail();
        if (tail != null) {
            _item.prev = tail;
            _item.next = this.dummy;
            tail.next = _item;
        } else {
            _item.prev = this.dummy;
            _item.next = this.dummy;
        }
        if (this.dummy.next == null) {
            this.dummy.next = _item;
        }
        this.dummy.prev = _item;
        listSize++;
    }

    public void addInHead(Node _item) {
        Node head = getHead();
        if (this.dummy.prev == null) {
            this.dummy.prev = _item;
            _item.next = this.dummy;
        }
        if (head != null) {
            head.prev = _item;
            _item.next = head;
            _item.prev = this.dummy;
        } else {
            _item.prev = this.dummy;
            _item.next = this.dummy;
        }
        this.dummy.next = _item;
        listSize++;
    }

    public Node find(int _value) {
        Node node = getHead();
        for (int i = 0; i < listSize; i++) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = getHead();
        for (int i = 0; i < listSize; i++) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = find(_value);
        if (node != null) {
            Node prev = node.prev;
            Node next = node.next;
            node.prev = null;
            node.next = null;
            prev.next = next;
            next.prev = prev;
            listSize--;
            return true;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = getHead();
        int step = listSize;
        for (int i = 0; i < step; i++) {
            if (node.value == _value) {
                Node nextNode = node.next;
                Node prev = node.prev;
                Node next = node.next;
                node.prev = null;
                node.next = null;
                prev.next = next;
                next.prev = prev;
                listSize--;
                node = nextNode;
                continue;
            }
            node = node.next;
        }
    }

    public void clear() {
        Node node = getHead();
        Node next = node.next;
        for (int i = 0; i < listSize; i++) {
            node.next = null;
            node.prev = null;
            node = next;
            next = node.next;
        }
        dummy.next = null;
        dummy.prev = null;

        listSize = 0;
    }

    public int count() {
        return listSize;
    }

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
            return;
        }
        if (_nodeToInsert != null) {
            Node after = find(_nodeAfter.value);
            if (after == null) {
                addInHead(_nodeToInsert);
                return;
            }
            Node next = after.next;
            after.next = _nodeToInsert;
            _nodeToInsert.prev = after;
            _nodeToInsert.next = next;
            next.prev = _nodeToInsert;
            listSize++;
        }
    }
}

class Node {
    public int value;
    public Node next;
    public Node prev;

    public Node(int _value) {
        value = _value;
        next = null;
        prev = null;
    }
}