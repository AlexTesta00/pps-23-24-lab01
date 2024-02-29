import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Iterator;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import iterator.BasicCircularListWithIterator;
import iterator.CircularListWithIterator;

public class CircularListWithIteratorTest {

    private final static int START_NUMBER = 1;
    private final static int END_NUMBER = 2;
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

    @Test
    public void correctForwardIterator(){
        populateCircularList(START_NUMBER, END_NUMBER);
        Iterator<Integer> iterator = this.circularListWithIterator.forwardIterator();
        for (int i = 0; i < 5; i++) {
            assertTrue(iterator.hasNext());
            assertEquals(1, iterator.next());
            assertTrue(iterator.hasNext());
            assertEquals(2, iterator.next());
        }
    }


    private void populateCircularList(int startInclusive, int endExclusive){
        IntStream.range(startInclusive, endExclusive).forEach(integerNumber ->{
            this.circularListWithIterator.add(integerNumber);
        });

        System.out.println(this.circularListWithIterator.size());
    }
}
