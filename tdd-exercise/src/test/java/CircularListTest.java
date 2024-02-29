import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.BasicCircularList;
import tdd.CircularList;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList circularList;

    @BeforeEach
    public void init(){
        this.circularList = new BasicCircularList();
    }

    @Test 
    public void correctInitSize(){
        assertEquals(0, this.circularList.size());
    }

    @Test 
    public void correctInitEmpty(){
        assertTrue(this.circularList.isEmpty());
    }

    @Test
    public void correctAddOfOneItemsInList(){
        this.circularList.add(1);
        assertEquals(1, this.circularList.size());
    }

    @Test
    public void isNotEmptyListIfAddOneItem(){
        this.circularList.add(1);
        assertFalse(this.circularList.isEmpty());
    }

    @Test
    public void checkCorrectNextElementWithEmptyList(){
        assertFalse(this.circularList.next().isPresent());
    }

    @Test
    public void checkCorrectNextElementWithoutEmptyList(){
        this.circularList.add(1);
        Optional<Integer> returnedElemntOfNext = this.circularList.next();
        assertEquals(1, returnedElemntOfNext.get());
    }

    @Test
    public void checkCorrectNextCircularity(){
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        this.circularList.next();
        this.circularList.next();
        this.circularList.next();
        Optional<Integer> returnedElemntOfNext = this.circularList.next();
        assertEquals(1, returnedElemntOfNext.get());
    }

    @Test
    public void checkCorrectPreviousElementWithEmptyList(){
        assertFalse(this.circularList.previous().isPresent());
    }

    @Test
    public void checkCorrectPreviousElementWithoutEmptyList(){
        this.circularList.add(1);
        Optional<Integer> returnedElemntOfNext = this.circularList.previous();
        assertEquals(1, returnedElemntOfNext.get());
    }

    @Test
    public void checkCorrectPreviousCircularity(){
        this.circularList.add(1);
        this.circularList.add(2);
        this.circularList.add(3);
        this.circularList.previous();
        this.circularList.previous();
        Optional<Integer> returnedElemntOfNext = this.circularList.previous();
        assertEquals(1, returnedElemntOfNext.get());
    }

}
