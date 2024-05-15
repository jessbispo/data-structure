package test;
import org.junit.Test;
import static org.junit.Assert.*;
import list.LinkedList;


public class LinkedListTest {
    
    @Test
    public void testInsert() {
        LinkedList list = new LinkedList();
        list.insert(10);
        assertEquals("10.0 ", list.toString());
    }

    @Test
    public void testAppend() {
        LinkedList list = new LinkedList();
        list.append(10);
        list.append(20);
        assertEquals("10.0 20.0 ", list.toString());
    }

    @Test
    public void testInsertAsc() {
        LinkedList list = new LinkedList();
        list.insertAsc(20);
        list.insertAsc(10);
        list.insertAsc(15);
        assertEquals("10.0 15.0 20.0 ", list.toString());
    }

    @Test
    public void testInsertAscNoDup() {
        LinkedList list = new LinkedList();
        assertTrue(list.insertAscNoDup(10));
        assertTrue(list.insertAscNoDup(20));
        assertFalse(list.insertAscNoDup(10)); // Should not insert duplicate
        assertEquals("10.0 20.0 ", list.toString());
    }

    @Test
    public void testInsertDesc() {
        LinkedList list = new LinkedList();
        list.insertDesc(10);
        list.insertDesc(20);
        list.insertDesc(15);
        assertEquals("20.0 15.0 10.0 ", list.toString());
    }

    @Test
    public void testInsertDescNoDup() {
        LinkedList list = new LinkedList();
        assertTrue(list.insertDescNoDup(10));
        assertTrue(list.insertDescNoDup(20));
        assertFalse(list.insertDescNoDup(10)); // Should not insert duplicate
        assertEquals("20.0 10.0 ", list.toString());
    }

    @Test
    public void testRemoveHead() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.removeHead();
        assertEquals("10.0 ", list.toString());
    }

    @Test
    public void testRemoveTail() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.removeTail();
        assertEquals("20.0 ", list.toString());
    }

    @Test
    public void testRemoveNode() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.removeNode(20);
        assertEquals("15.0 10.0 ", list.toString());
    }

    @Test
    public void testRemoveDup() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(10);
        list.removeDup();
        assertEquals("10.0 20.0 ", list.toString());
    }

    @Test
    public void testSort() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.sort();
        assertEquals("10.0 15.0 20.0 ", list.toString());
    }

    @Test
    public void testReverse() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.insert(15);
        list.reverse();
        assertEquals("10.0 20.0 15.0 ", list.toString());
    }

    @Test
    public void testClear() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        list.clear();
        assertEquals("", list.toString());
    }

    @Test
    public void testCount() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        assertEquals(2, list.count());
    }

    @Test
    public void testIsEqual() {
        LinkedList list1 = new LinkedList();
        list1.insert(10);
        list1.insert(20);

        LinkedList list2 = new LinkedList();
        list2.insert(10);
        list2.insert(20);

        assertTrue(list1.isEqual(list2));
    }


    @Test
    public void testGetHead() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        assertEquals(20.0f, list.getHead().getData(), 0.001);
    }

    @Test
    public void testGetTail() {
        LinkedList list = new LinkedList();
        list.insert(10);
        list.insert(20);
        assertEquals(10.0f, list.getTail().getData(), 0.001);
    }

    @Test
    public void testIsEmpty() {
        LinkedList list = new LinkedList();
        assertTrue(list.isEmpty());
        list.insert(10);
        assertFalse(list.isEmpty());
    }
}

//https://junit.org/junit5/docs/current/user-guide/
//https://stackoverflow.com/questions/15105556/the-import-org-junit-cannot-be-resolved
//https://stackoverflow.com/questions/2235276/how-to-run-junit-test-cases-from-the-command-line
//https://www.devmedia.com.br/junit-tutorial/1432
//https://code.visualstudio.com/docs/java/java-testing
//https://junit.org/junit4/