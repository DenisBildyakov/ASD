package LinkedList2;

import java.util.*;

public class LinkedList2 {
    public Node head;
    public Node tail;

    private int listSize;

    public LinkedList2() {
        head = null;
        tail = null;
        listSize = 0;
    }

    public void addInTail(Node _item) {
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

    public void addInHead(Node _item) {
        Node tmp = this.head;
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

    public Node find(int _value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == _value)
                return node;
            node = node.next;
        }
        return null;
    }

    public ArrayList<Node> findAll(int _value) {
        ArrayList<Node> nodes = new ArrayList<>();
        Node node = this.head;
        while (node != null) {
            if (node.value == _value) {
                nodes.add(node);
            }
            node = node.next;
        }
        return nodes;
    }

    public boolean remove(int _value) {
        Node node = this.head;
        Node prev = null;
        while (node != null) {
            if (node.value == _value) {
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
                    return true;
                }
                if (node.next == null) {
                    Node toDelete = this.tail;
                    this.tail = prev;
                    this.tail.next = null;
                    toDelete.prev = null;
                    listSize--;
                    return true;
                }
                Node next = node.next;
                prev.next = next;
                next.prev = prev;
                node.next = null;
                node.prev = null;
                listSize--;
                return true;
            }
            prev = node;
            node = node.next;
        }
        return false;
    }

    public void removeAll(int _value) {
        Node node = this.head;
        Node prev = null;
        while (node != null) {
            if (node.value == _value) {
                if (prev == null) {
                    Node tmp = node.next;
                    this.head.next = null;
                    this.head = tmp;
                    if (this.head != null) {
                        this.head.prev = null;
                    }
                    listSize--;
                    if (listSize == 0) {
                        this.tail = null;
                        node = null;
                        continue;
                    }
                    node = tmp;
                    continue;
                }
                if (node.next == null) {
                    this.tail = prev;
                    this.tail.next = null;
                    listSize--;
                    node.prev = null;
                    node = null;
                    continue;
                }
                Node toRemove = node;
                prev.next = node.next;
                node.next.prev = prev;
                node = node.next;
                toRemove.next = null;
                toRemove.prev = null;
                listSize--;
                continue;
            }
            prev = node;
            node = node.next;
        }
    }

    public void clear() {
        Node node = this.head;
        Node next = node.next;
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

    public void insertAfter(Node _nodeAfter, Node _nodeToInsert) {
        if (_nodeAfter == null) {
            addInHead(_nodeToInsert);
        } else {
            if (_nodeToInsert != null) {
                Node after = find(_nodeAfter.value);
                if (after != null) {
                    Node next = after.next;
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