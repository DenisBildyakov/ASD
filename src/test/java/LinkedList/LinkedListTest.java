package LinkedList;


import LinkedList2Dummy.LinkedList2Dummy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void addInTail() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(1));
        assertEquals(1, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        linkedList.addInTail(new Node(2));
        assertEquals(1, linkedList.getHead().value);
        assertEquals(2, linkedList.getTail().value);

        linkedList.addInTail(new Node(3));
        assertEquals(1, linkedList.getHead().value);
        assertEquals(2, linkedList.getHead().next.value);
        assertEquals(3, linkedList.getTail().value);
    }

    @Test
    void addInHead() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInHead(new Node(1));
        assertEquals(1, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        linkedList.addInHead(new Node(2));
        assertEquals(2, linkedList.getHead().value);
        assertEquals(1, linkedList.getTail().value);

        linkedList.addInHead(new Node(3));
        assertEquals(3, linkedList.getHead().value);
        assertEquals(2, linkedList.getHead().next.value);
        assertEquals(1, linkedList.getTail().value);
    }

    @Test
    void find() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(1));
        Node node = linkedList.find(1);
        assertSame(node, linkedList.getHead());
        assertEquals(node.value, linkedList.getHead().value);
        assertEquals(node.value, linkedList.getTail().value);

        linkedList.addInTail(new Node(2));
        Node node1 = linkedList.find(1);
        Node node2 = linkedList.find(2);
        assertSame(node1, linkedList.getHead());
        assertSame(node2, linkedList.getTail());
        assertEquals(node1.value, linkedList.getHead().value);
        assertEquals(node2.value, linkedList.getHead().next.value);
        assertEquals(node2.value, linkedList.getTail().value);

        linkedList.addInTail(new Node(3));
        Node node3 = linkedList.find(3);
        assertSame(node3, linkedList.getTail());
        assertEquals(node1.value, linkedList.getHead().value);
        assertEquals(node2.value, linkedList.getHead().next.value);
        assertEquals(node3.value, linkedList.getTail().value);
    }

    @Test
    void findAll() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList.addInTail(new Node(i));
        }
        assertEquals(10, linkedList.count());
        assertEquals(1, linkedList.findAll(0).size());
        assertEquals(1, linkedList.findAll(5).size());
        assertEquals(1, linkedList.findAll(9).size());

        linkedList.addInTail(new Node(5));
        assertEquals(2, linkedList.findAll(5).size());

        linkedList.addInTail(new Node(5));
        assertEquals(3, linkedList.findAll(5).size());

        linkedList.addInHead(new Node(5));
        assertEquals(4, linkedList.findAll(5).size());

        linkedList.insertAfter(new Node(3), new Node(5));
        assertEquals(5, linkedList.findAll(5).size());
    }

    @Test
    void remove() {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addInTail(new Node(1));
        assertEquals(1, linkedList1.count());
        assertEquals(1, linkedList1.getTail().value);
        assertEquals(1, linkedList1.getHead().value);
        linkedList1.remove(1);
        assertEquals(0, linkedList1.count());
        assertNull(linkedList1.getTail());
        assertNull(linkedList1.getHead());


        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList2.addInTail(new Node(i));
        }
        assertEquals(5, linkedList2.find(5).value);
        linkedList2.remove(5);
        assertNull(linkedList2.find(5));


        LinkedList linkedList3 = new LinkedList();
        linkedList3.addInTail(new Node(1));
        linkedList3.addInTail(new Node(2));
        assertEquals(2, linkedList3.count());
        assertEquals(1, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);
        linkedList3.remove(1);
        assertEquals(1, linkedList3.count());
        assertEquals(2, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);
    }

    @Test
    void removeAll() {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addInTail(new Node(1));
        linkedList1.addInTail(new Node(1));
        assertEquals(2, linkedList1.count());
        assertEquals(1, linkedList1.getTail().value);
        assertEquals(1, linkedList1.getHead().value);
        linkedList1.removeAll(1);
        assertEquals(0, linkedList1.count());
        assertNull(linkedList1.getTail());
        assertNull(linkedList1.getHead());


        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList2.addInTail(new Node(i));
            linkedList2.addInTail(new Node(i));
        }
        assertEquals(2, linkedList2.findAll(5).size());
        linkedList2.removeAll(5);
        assertNull(linkedList2.find(5));
        assertEquals(0, linkedList2.findAll(5).size());


        LinkedList linkedList3 = new LinkedList();
        linkedList3.addInTail(new Node(1));
        linkedList3.addInTail(new Node(1));
        linkedList3.addInTail(new Node(2));
        linkedList3.addInTail(new Node(2));
        assertEquals(4, linkedList3.count());
        assertEquals(1, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);
        linkedList3.removeAll(1);
        assertEquals(2, linkedList3.count());
        assertEquals(2, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);
    }

    @Test
    void clear() {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.addInTail(new Node(1));
        assertEquals(1, linkedList1.count());
        assertEquals(1, linkedList1.getTail().value);
        assertEquals(1, linkedList1.getHead().value);
        linkedList1.clear();
        assertEquals(0, linkedList1.count());
        assertNull(linkedList1.getTail());
        assertNull(linkedList1.getHead());


        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList2.addInTail(new Node(i));
        }
        assertEquals(10, linkedList2.count());
        linkedList2.clear();
        assertEquals(0, linkedList2.count());
        assertNull(linkedList2.getTail());
        assertNull(linkedList2.getHead());


        LinkedList linkedList3 = new LinkedList();
        linkedList3.addInTail(new Node(1));
        linkedList3.addInTail(new Node(2));
        assertEquals(2, linkedList3.count());
        assertEquals(1, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);
        linkedList3.clear();
        assertEquals(0, linkedList3.count());
        assertNull(linkedList3.getTail());
        assertNull(linkedList3.getHead());
    }

    @Test
    void count() {
        LinkedList linkedList = new LinkedList();
        linkedList.addInTail(new Node(1));
        assertEquals(1, linkedList.count());
        linkedList.addInTail(new Node(2));
        assertEquals(2, linkedList.count());
        linkedList.addInTail(new Node(5));
        assertEquals(3, linkedList.count());
        linkedList.remove(2);
        assertEquals(2, linkedList.count());
        linkedList.remove(5);
        assertEquals(1, linkedList.count());
        linkedList.remove(1);
        assertEquals(0, linkedList.count());
    }

    @Test
    void insertAfter() {
        LinkedList linkedList1 = new LinkedList();
        linkedList1.insertAfter(null, new Node(1));
        assertEquals(1, linkedList1.count());
        assertEquals(1, linkedList1.getHead().value);
        assertEquals(1, linkedList1.getTail().value);

        LinkedList linkedList2 = new LinkedList();
        linkedList2.insertAfter(new Node(1), new Node(1));
        assertEquals(1, linkedList2.count());
        assertEquals(1, linkedList2.getHead().value);
        assertEquals(1, linkedList2.getTail().value);

        LinkedList linkedList3 = new LinkedList();
        linkedList3.addInTail(new Node(1));
        Node node1 = linkedList3.find(1);
        linkedList3.insertAfter(node1, new Node(2));
        assertEquals(2, linkedList3.count());
        assertEquals(1, linkedList3.getHead().value);
        assertEquals(2, linkedList3.getTail().value);

        LinkedList linkedList4 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList4.addInTail(new Node(i));
        }
        linkedList4.insertAfter(linkedList4.find(5), new Node(999));
        Node node2 = linkedList4.find(5);
        assertEquals(999, node2.next.value);
    }

    @Test
    void twoListAddition() {
        LinkedList linkedList1 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList1.addInTail(new Node(1));
        }
        LinkedList linkedList2 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList2.addInTail(new Node(2));
        }
        LinkedList result1 = LinkedList.twoListAddition(linkedList1, linkedList2);
        assertNotNull(result1);
        assertEquals(10, result1.count());
        Node node = result1.getHead();
        for (int i = 0; i < result1.count(); i++) {
            assertEquals(3, node.value);
            node = node.next;
        }


        LinkedList linkedList3 = new LinkedList();
        for (int i = 0; i < 10; i++) {
            linkedList3.addInTail(new Node(1));
        }
        LinkedList linkedList4 = new LinkedList();
        for (int i = 0; i < 11; i++) {
            linkedList4.addInTail(new Node(2));
        }
        LinkedList result2 = LinkedList.twoListAddition(linkedList3, linkedList4);
        assertNull(result2);
    }
}