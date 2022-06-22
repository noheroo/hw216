package Implements;

import Exceptions.ArrayIsFullException;
import Exceptions.BadIndexException;
import Exceptions.ItemIsNullException;
import org.junit.jupiter.api.Test;

import static Implements.Constants.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IntegerListImplTest {

    private final IntegerListImpl out = new IntegerListImpl(FIVE);

    @Test
    void addElementWithoutIndex() {
        assertEquals(out.add(INTEGER), INTEGER);

    }

    @Test
    void testAddElementByIndex() {
        out.add(INTEGER1);
        assertEquals(out.add(ONE, INTEGER), INTEGER);
    }

    @Test
    void setElementByIndex() {
        out.add(INTEGER);
        assertEquals(out.set(ZERO, INTEGER1), INTEGER1);
    }

    @Test
    void removeElementByIndex() {
        out.add(INTEGER1);
        assertEquals(out.remove(ZERO), INTEGER1);
    }

    @Test
    void testRemoveWithoutIndex() {
        out.add(INTEGER);
        assertEquals(out.remove(INTEGER), INTEGER);
    }

    @Test
    void containsElementByItem() {
        out.add(INTEGER3);
        out.add(INTEGER4);
        out.add(INTEGER);
        out.add(INTEGER2);
        out.add(INTEGER1);
        assertEquals(out.contains(INTEGER1), TRUE);
    }

    @Test
    void indexOf() {
        out.add(INTEGER);
        out.add(INTEGER1);

        assertEquals(out.indexOf(INTEGER1),ONE);
    }

    @Test
    void lastIndexOf() {
        out.add(INTEGER);
        out.add(INTEGER1);

        assertEquals(out.indexOf(INTEGER1),ONE);
    }

    @Test
    void get() {
        out.add(INTEGER);
        out.add(INTEGER1);

        assertEquals(out.get(ONE), INTEGER1);
    }

    @Test
    void size() {
        out.add(INTEGER);
        out.add(INTEGER1);

        assertEquals(out.size(),TWO);
    }

    @Test
    void isEmpty() {
        assertEquals(out.isEmpty(),TRUE);
    }

    @Test
    void ItemIsNullExceptionTest() {
        assertThrows(ItemIsNullException.class, () -> out.add(NULL));
    }

    @Test
    void BadIndexExceptionTest() {
        assertThrows(BadIndexException.class, () -> out.add(MINUS_FIVE,INTEGER));
    }

    @Test
    void ArrayIsFullExceptionTest() {
        out.add(INTEGER3);
        out.add(INTEGER4);
        out.add(INTEGER);
        out.add(INTEGER2);
        out.add(INTEGER1);
        assertThrows(ArrayIsFullException.class, () -> out.add(INTEGER));
    }
}