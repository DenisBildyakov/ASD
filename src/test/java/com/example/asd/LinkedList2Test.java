package com.example.asd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2Test {

    @Test
    void find() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(24));
        linkedList.addInTail(new Node(31));

        Node findNode1 = linkedList.find(24);
        Assertions.assertEquals(24, findNode1.value);

        Node findNode2 = linkedList.find(31);
        Assertions.assertEquals(31, findNode2.value);
    }

    @Test
    void findAll() {
        LinkedList2 linkedList = new LinkedList2();
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
    void remove_fullList() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(7));
        linkedList.addInTail(new Node(8));
        linkedList.addInTail(new Node(9));
        linkedList.addInTail(new Node(10));
        linkedList.addInTail(new Node(11));

        Assertions.assertEquals(7, linkedList.count());


        Node toDelete = linkedList.find(6);
        assertTrue(linkedList.remove(6));
        assertNull(linkedList.find(6));
        assertNull(toDelete.prev);
        assertNull(toDelete.next);
        Assertions.assertEquals(7, linkedList.head.next.value);
        Assertions.assertEquals(5, linkedList.find(7).prev.value);
        Assertions.assertEquals(6, linkedList.count());

        assertTrue(linkedList.remove(5));
        assertNull(linkedList.find(5));
        Assertions.assertEquals(7, linkedList.head.value);
        Assertions.assertEquals(8, linkedList.head.next.value);
        assertNull(linkedList.head.prev);
        Assertions.assertEquals(5, linkedList.count());

        assertTrue(linkedList.remove(11));
        assertNull(linkedList.find(11));
        Assertions.assertEquals(10, linkedList.tail.value);
        assertNull(linkedList.tail.next);
        Assertions.assertEquals(9, linkedList.tail.prev.value);
        Assertions.assertEquals(4, linkedList.count());
    }

    @Test
    void remove_singleList() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        Assertions.assertEquals(1, linkedList.count());

        Node toDelete = linkedList.find(5);
        assertTrue(linkedList.remove(5));
        assertNull(linkedList.find(5));
        assertNull(toDelete.prev);
        assertNull(toDelete.next);
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
        Assertions.assertEquals(0, linkedList.count());
    }

    @Test
    void remove_emptyList() {
        LinkedList2 linkedList = new LinkedList2();
        Assertions.assertEquals(0, linkedList.count());

        assertFalse(linkedList.remove(5));
        assertNull(linkedList.find(5));
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
        Assertions.assertEquals(0, linkedList.count());
    }

    @Test
    void removeAll_fullList() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(24));
        linkedList.addInTail(new Node(31));

        //////////////
        ArrayList<Node> findList1 = linkedList.findAll(12);
        Assertions.assertEquals(2, findList1.size());
        linkedList.removeAll(12);
        ArrayList<Node> findList2 = linkedList.findAll(12);
        Assertions.assertEquals(0, findList2.size());
        for (Node node : findList1) {
            assertNull(node.next);
            assertNull(node.prev);
        }
        Assertions.assertEquals(5, linkedList.count());
        Assertions.assertEquals(5, linkedList.find(6).next.value);
        Assertions.assertEquals(5, linkedList.find(6).prev.value);
        //////////////
        ArrayList<Node> findList3 = linkedList.findAll(5);
        Assertions.assertEquals(2, findList3.size());
        linkedList.removeAll(5);
        ArrayList<Node> findList4 = linkedList.findAll(5);
        Assertions.assertEquals(0, findList4.size());
        for (Node node : findList3) {
            assertNull(node.next);
            assertNull(node.prev);
        }
        Assertions.assertEquals(6, linkedList.head.value);
        Assertions.assertEquals(24, linkedList.head.next.value);
        Assertions.assertEquals(6, linkedList.find(24).prev.value);
        Assertions.assertEquals(3, linkedList.count());
        //////////////
        ArrayList<Node> findList5 = linkedList.findAll(31);
        Assertions.assertEquals(1, findList5.size());
        linkedList.removeAll(31);
        ArrayList<Node> findList6 = linkedList.findAll(31);
        Assertions.assertEquals(0, findList6.size());
        for (Node node : findList5) {
            assertNull(node.next);
            assertNull(node.prev);
        }
        Assertions.assertEquals(6, linkedList.head.value);
        assertNull(linkedList.head.prev);
        Assertions.assertEquals(24, linkedList.head.next.value);
        Assertions.assertEquals(24, linkedList.tail.value);
        Assertions.assertEquals(6, linkedList.tail.prev.value);
        assertNull(linkedList.tail.next);
        Assertions.assertEquals(2, linkedList.count());
    }

    @Test
    void removeAll_singleList() { // доделать
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));

        ArrayList<Node> findList1 = linkedList.findAll(5);
        Assertions.assertEquals(1, findList1.size());
        linkedList.removeAll(5);
        ArrayList<Node> findList2 = linkedList.findAll(5);
        Assertions.assertEquals(0, findList2.size());
        for (Node node : findList1) {
            assertNull(node.next);
            assertNull(node.prev);
        }
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void removeAll_emptyList() {
        LinkedList2 linkedList = new LinkedList2();

        ArrayList<Node> findList1 = linkedList.findAll(5);
        Assertions.assertEquals(0, findList1.size());
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void clear() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(24));
        linkedList.addInTail(new Node(31));

        Assertions.assertEquals(7, linkedList.count());

        ArrayList<Node> findList = linkedList.findAll(12);
        Assertions.assertEquals(2, findList.size());
        linkedList.clear();
        for (Node node : findList) {
            assertNull(node.next);
            assertNull(node.prev);
        }

        Assertions.assertEquals(0, linkedList.count());
        assertNull(linkedList.head);
        assertNull(linkedList.tail);
    }

    @Test
    void insertAfter() {
        LinkedList2 linkedList = new LinkedList2();
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(6));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(12));
        linkedList.addInTail(new Node(5));
        linkedList.addInTail(new Node(24));
        linkedList.addInTail(new Node(31));

        linkedList.insertAfter(null, new Node(88));
        Assertions.assertEquals(88, linkedList.head.value);
        assertNull(linkedList.head.prev);
        Assertions.assertEquals(5, linkedList.head.next.value);
        Assertions.assertEquals(8, linkedList.count());

        linkedList.insertAfter(linkedList.find(31), new Node(99));
        Assertions.assertEquals(99, linkedList.tail.value);
        assertNull(linkedList.tail.next);
        Assertions.assertEquals(31, linkedList.tail.prev.value);
        Assertions.assertEquals(9, linkedList.count());

        linkedList.insertAfter(linkedList.find(6), new Node(77));
        Assertions.assertEquals(6, linkedList.find(77).prev.value);
        Assertions.assertEquals(12, linkedList.find(77).next.value);
        Assertions.assertEquals(77, linkedList.find(6).next.value);
        Assertions.assertEquals(77, linkedList.find(12).prev.value);
        Assertions.assertEquals(10, linkedList.count());

    }

    @Test
    void insertAfter_empty() {
        LinkedList2 linkedList1 = new LinkedList2();

        linkedList1.insertAfter(null, new Node(88));
        Assertions.assertEquals(88, linkedList1.head.value);
        Assertions.assertEquals(88, linkedList1.tail.value);

    }
}