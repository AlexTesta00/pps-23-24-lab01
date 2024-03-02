import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iterator.BasicCircularListWithIterator;
import iterator.CircularListWithIterator;

public class CircularListWithIteratorTest {

    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 3;
    private final static int ATTEMPS = 10;
    private CircularListWithIterator circularListWithIterator;

    @BeforeEach
    public void init(){
        this.circularListWithIterator = new BasicCircularListWithIterator();
    }

    @Test
    public void emptyForwardIterator(){
        assertFalse(this.circularListWithIterator.forwardIterator().hasNext());
    }

    @Test
    public void emptyBackwordIterator(){
        assertFalse(this.circularListWithIterator.backwardIterator().hasNext());
    }

    private void populateCircularList(int startInclusive, int endExclusive){
        for (int i = startInclusive; i < endExclusive; i++) {
            this.circularListWithIterator.add(i);
        }
    }
    
    @Test
    public void correctForwardIterator(){
        populateCircularList(START_NUMBER, END_NUMBER);
        Iterator<Integer> iterator = this.circularListWithIterator.forwardIterator();
        for (int i = 0; i < ATTEMPS; i++) {
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
        }
    }

    @Test
    public void correctBackwordIterator(){
        populateCircularList(START_NUMBER, END_NUMBER);
        Iterator<Integer> iterator = this.circularListWithIterator.backwardIterator();
        for (int i = 0; i < ATTEMPS; i++) {
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
        }
    }
}
