package LinkedList2Dummy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedList2DummyTest {

    @Test
    void addInTail() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        assertEquals(1, linkedList2Dummy1.getHead().value);
        assertEquals(1, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInTail(new Node(2));
        assertEquals(1, linkedList2Dummy1.getHead().value);
        assertEquals(2, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInTail(new Node(3));
        assertEquals(1, linkedList2Dummy1.getHead().value);
        assertEquals(2, linkedList2Dummy1.getHead().next.value);
        assertEquals(2, linkedList2Dummy1.getTail().prev.value);
        assertEquals(3, linkedList2Dummy1.getTail().value);
    }

    @Test
    void addInHead() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInHead(new Node(1));
        assertEquals(1, linkedList2Dummy1.getHead().value);
        assertEquals(1, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInHead(new Node(2));
        assertEquals(2, linkedList2Dummy1.getHead().value);
        assertEquals(1, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInHead(new Node(3));
        assertEquals(3, linkedList2Dummy1.getHead().value);
        assertEquals(2, linkedList2Dummy1.getHead().next.value);
        assertEquals(2, linkedList2Dummy1.getTail().prev.value);
        assertEquals(1, linkedList2Dummy1.getTail().value);
    }

    @Test
    void find() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        Node node = linkedList2Dummy1.find(1);
        assertSame(node, linkedList2Dummy1.getHead());
        assertEquals(node.value, linkedList2Dummy1.getHead().value);
        assertEquals(node.value, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInTail(new Node(2));
        Node node1 = linkedList2Dummy1.find(1);
        Node node2 = linkedList2Dummy1.find(2);
        assertSame(node1, linkedList2Dummy1.getHead());
        assertSame(node2, linkedList2Dummy1.getTail());
        assertEquals(node1.value, linkedList2Dummy1.getHead().value);
        assertEquals(node2.value, linkedList2Dummy1.getHead().next.value);
        assertEquals(node1.value, linkedList2Dummy1.getTail().prev.value);
        assertEquals(node2.value, linkedList2Dummy1.getTail().value);

        linkedList2Dummy1.addInTail(new Node(3));
        Node node3 = linkedList2Dummy1.find(3);
        assertSame(node3, linkedList2Dummy1.getTail());
        assertEquals(node1.value, linkedList2Dummy1.getHead().value);
        assertEquals(node2.value, linkedList2Dummy1.getHead().next.value);
        assertEquals(node2.value, linkedList2Dummy1.getTail().prev.value);
        assertEquals(node3.value, linkedList2Dummy1.getTail().value);
    }

    @Test
    void findAll() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        for (int i = 0; i < 10; i++) {
            linkedList2Dummy1.addInTail(new Node(i));
        }
        assertEquals(10, linkedList2Dummy1.count());
        assertEquals(1, linkedList2Dummy1.findAll(0).size());
        assertEquals(1, linkedList2Dummy1.findAll(5).size());
        assertEquals(1, linkedList2Dummy1.findAll(9).size());

        linkedList2Dummy1.addInTail(new Node(5));
        assertEquals(2, linkedList2Dummy1.findAll(5).size());

        linkedList2Dummy1.addInTail(new Node(5));
        assertEquals(3, linkedList2Dummy1.findAll(5).size());

        linkedList2Dummy1.addInHead(new Node(5));
        assertEquals(4, linkedList2Dummy1.findAll(5).size());

        linkedList2Dummy1.insertAfter(new Node(3), new Node(5));
        assertEquals(5, linkedList2Dummy1.findAll(5).size());
    }

    @Test
    void remove() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        assertEquals(1, linkedList2Dummy1.count());
        assertEquals(1, linkedList2Dummy1.getTail().value);
        assertEquals(1, linkedList2Dummy1.getHead().value);
        linkedList2Dummy1.remove(1);
        assertEquals(0, linkedList2Dummy1.count());
        assertNull(linkedList2Dummy1.getTail());
        assertNull(linkedList2Dummy1.getHead());


        LinkedList2Dummy linkedList2Dummy2 = new LinkedList2Dummy();
        for (int i = 0; i < 10; i++) {
            linkedList2Dummy2.addInTail(new Node(i));
        }
        assertEquals(5, linkedList2Dummy2.find(5).value);
        linkedList2Dummy2.remove(5);
        assertNull(linkedList2Dummy2.find(5));


        LinkedList2Dummy linkedList2Dummy3 = new LinkedList2Dummy();
        linkedList2Dummy3.addInTail(new Node(1));
        linkedList2Dummy3.addInTail(new Node(2));
        assertEquals(2, linkedList2Dummy3.count());
        assertEquals(1, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);
        linkedList2Dummy3.remove(1);
        assertEquals(1, linkedList2Dummy3.count());
        assertEquals(2, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);
    }

    @Test
    void removeAll() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        linkedList2Dummy1.addInTail(new Node(1));
        assertEquals(2, linkedList2Dummy1.count());
        assertEquals(1, linkedList2Dummy1.getTail().value);
        assertEquals(1, linkedList2Dummy1.getHead().value);
        linkedList2Dummy1.removeAll(1);
        assertEquals(0, linkedList2Dummy1.count());
        assertNull(linkedList2Dummy1.getTail());
        assertNull(linkedList2Dummy1.getHead());


        LinkedList2Dummy linkedList2Dummy2 = new LinkedList2Dummy();
        for (int i = 0; i < 10; i++) {
            linkedList2Dummy2.addInTail(new Node(i));
            linkedList2Dummy2.addInTail(new Node(i));
        }
        assertEquals(2, linkedList2Dummy2.findAll(5).size());
        linkedList2Dummy2.removeAll(5);
        assertNull(linkedList2Dummy2.find(5));
        assertEquals(0, linkedList2Dummy2.findAll(5).size());


        LinkedList2Dummy linkedList2Dummy3 = new LinkedList2Dummy();
        linkedList2Dummy3.addInTail(new Node(1));
        linkedList2Dummy3.addInTail(new Node(1));
        linkedList2Dummy3.addInTail(new Node(2));
        linkedList2Dummy3.addInTail(new Node(2));
        assertEquals(4, linkedList2Dummy3.count());
        assertEquals(1, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);
        linkedList2Dummy3.removeAll(1);
        assertEquals(2, linkedList2Dummy3.count());
        assertEquals(2, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);
    }

    @Test
    void clear() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        assertEquals(1, linkedList2Dummy1.count());
        assertEquals(1, linkedList2Dummy1.getTail().value);
        assertEquals(1, linkedList2Dummy1.getHead().value);
        linkedList2Dummy1.clear();
        assertEquals(0, linkedList2Dummy1.count());
        assertNull(linkedList2Dummy1.getTail());
        assertNull(linkedList2Dummy1.getHead());


        LinkedList2Dummy linkedList2Dummy2 = new LinkedList2Dummy();
        for (int i = 0; i < 10; i++) {
            linkedList2Dummy2.addInTail(new Node(i));
        }
        assertEquals(10, linkedList2Dummy2.count());
        linkedList2Dummy2.clear();
        assertEquals(0, linkedList2Dummy2.count());
        assertNull(linkedList2Dummy2.getTail());
        assertNull(linkedList2Dummy2.getHead());


        LinkedList2Dummy linkedList2Dummy3 = new LinkedList2Dummy();
        linkedList2Dummy3.addInTail(new Node(1));
        linkedList2Dummy3.addInTail(new Node(2));
        assertEquals(2, linkedList2Dummy3.count());
        assertEquals(1, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);
        linkedList2Dummy3.clear();
        assertEquals(0, linkedList2Dummy3.count());
        assertNull(linkedList2Dummy3.getTail());
        assertNull(linkedList2Dummy3.getHead());
    }

    @Test
    void count() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.addInTail(new Node(1));
        assertEquals(1, linkedList2Dummy1.count());
        linkedList2Dummy1.addInTail(new Node(2));
        assertEquals(2, linkedList2Dummy1.count());
        linkedList2Dummy1.addInTail(new Node(5));
        assertEquals(3, linkedList2Dummy1.count());
        linkedList2Dummy1.remove(2);
        assertEquals(2, linkedList2Dummy1.count());
        linkedList2Dummy1.remove(5);
        assertEquals(1, linkedList2Dummy1.count());
        linkedList2Dummy1.remove(1);
        assertEquals(0, linkedList2Dummy1.count());
    }

    @Test
    void insertAfter() {
        LinkedList2Dummy linkedList2Dummy1 = new LinkedList2Dummy();
        linkedList2Dummy1.insertAfter(null, new Node(1));
        assertEquals(1, linkedList2Dummy1.count());
        assertEquals(1, linkedList2Dummy1.getHead().value);
        assertEquals(1, linkedList2Dummy1.getTail().value);

        LinkedList2Dummy linkedList2Dummy2 = new LinkedList2Dummy();
        linkedList2Dummy2.insertAfter(new Node(1), new Node(1));
        assertEquals(1, linkedList2Dummy2.count());
        assertEquals(1, linkedList2Dummy2.getHead().value);
        assertEquals(1, linkedList2Dummy2.getTail().value);

        LinkedList2Dummy linkedList2Dummy3 = new LinkedList2Dummy();
        linkedList2Dummy3.addInTail(new Node(1));
        Node node1 = linkedList2Dummy3.find(1);
        linkedList2Dummy3.insertAfter(node1, new Node(2));
        assertEquals(2, linkedList2Dummy3.count());
        assertEquals(1, linkedList2Dummy3.getHead().value);
        assertEquals(2, linkedList2Dummy3.getTail().value);

        LinkedList2Dummy linkedList2Dummy4 = new LinkedList2Dummy();
        for (int i = 0; i < 10; i++) {
            linkedList2Dummy4.addInTail(new Node(i));
        }
        linkedList2Dummy4.insertAfter(linkedList2Dummy4.find(5), new Node(999));
        Node node2 = linkedList2Dummy4.find(5);
        Node node3 = linkedList2Dummy4.find(6);
        assertEquals(999, node2.next.value);
        assertEquals(999, node3.prev.value);
    }
}