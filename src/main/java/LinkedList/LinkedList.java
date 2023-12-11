package LinkedList;

import java.util.*;

public class LinkedList {
    public Node head;
    public Node tail;

    public int listSize;

    public LinkedList() {
        head = null;
        tail = null;
        listSize = 0;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public void addInTail(Node item) {
        if (this.head == null)
            this.head = item;
        else
            this.tail.next = item;
        this.tail = item;
        listSize++;
    }

    public void addInHead(Node item) {
        item.next = this.head;
        this.head = item;
        if (listSize == 0) {
            this.tail = item;
        }
        listSize++;
    }

    public Node find(int value) {
        Node node = this.head;
        while (node != null) {
            if (node.value == value)
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
                    node.next = null;
                    listSize--;
                    if (listSize == 0) {
                        this.tail = null;
                    }
                    return true;
                }
                if (node.next == null) {
                    this.tail = prev;
                    this.tail.next = null;
                    listSize--;
                    return true;
                }
                prev.next = node.next;
                node.next = null;
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
        int step = listSize;
        for (int i = 0; i < step; i++) {
            if (node.value == _value) {
                Node nextNode = node.next;
                node.next = null;
                listSize--;
                if (prev == null) {
                    this.head = nextNode;
                } else {
                    prev.next = nextNode;
                }
                if (nextNode == null) {
                    this.tail = prev;
                }
                node = nextNode;
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
                    _nodeToInsert.next = next;
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

    public static LinkedList twoListAddition(LinkedList list1, LinkedList list2) {
        if (list1.count() != list2.count()) return null;
        LinkedList listOfTwo = new LinkedList();
        Node node1 = list1.head;
        Node node2 = list2.head;
        for (int i = 0; i < list1.count(); i++) {
            listOfTwo.addInTail(new Node(node1.value + node2.value));
            node1 = node1.next;
            node2 = node2.next;
        }
        return listOfTwo;
    }
}

class Node {
    public int value;
    public Node next;

    public Node(int _value) {
        value = _value;
        next = null;
    }
}