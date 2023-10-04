package com.example.asd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void findAll() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(24));
        linkedList.addInTail(new Node(31));

        java.util.ArrayList<Node> list1 = linkedList.findAll(12);
        Assertions.assertEquals(2, list1.size());

        java.util.ArrayList<Node> list2 = linkedList.findAll(5);
        Assertions.assertEquals(2, list2.size());

        java.util.ArrayList<Node> list3 = linkedList.findAll(31);
        Assertions.assertEquals(1, list3.size());
    }

    @Test
    void remove() {
    }

    @Test
    void removeAll() {
    }

    @Test
    void clear() {
    }

    @Test
    void count() {
    }

    @Test
    void insertAfter() {
    }
}