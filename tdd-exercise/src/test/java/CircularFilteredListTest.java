import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Optional;

import filtered.CircularFilteredList;
import filtered.CircularFilteredListImpl;

public class CircularFilteredListTest {

    private CircularFilteredList circularFilteredList;
    
    @BeforeEach
    public void init(){
        this.circularFilteredList = new CircularFilteredListImpl();
    }

    private boolean alwaysTrueFilter(int item) {
        return true;
    }

    @Test
    public void filterIfListIsEmpty(){
        final Optional<Integer> nextElement = this.circularFilteredList.filteredNext(this::alwaysTrueFilter);
        assertFalse(nextElement.isPresent());
    }

    private void addItems(int... items){
        for(int item: items){
            this.circularFilteredList.add(item);
        }
    }

    private boolean filterOddNumber(int item){
        return !(item % 2 == 0);
    }

    private boolean filterEvenNumber(int item){
        return !filterOddNumber(item);
    }

    @Test
    public void onlyOddNumber(){
        this.addItems(1,2,4,6);
        Optional<Integer> nextItem;
        nextItem =  this.circularFilteredList.filteredNext(this::filterOddNumber);
        assertEquals(1, nextItem.get());
        nextItem =  this.circularFilteredList.filteredNext(this::filterOddNumber);
        assertEquals(1, nextItem.get());
    }

    @Test
    public void testCircularity(){
        this.addItems(1,2,3,4,5,6);
        Optional<Integer> next;
        next = this.circularFilteredList.filteredNext(this::filterEvenNumber);
        assertEquals(2, next.get());
        next = this.circularFilteredList.filteredNext(this::filterEvenNumber);
        assertEquals(4, next.get());
        next = this.circularFilteredList.filteredNext(this::filterEvenNumber);
        assertEquals(6, next.get());
        next = this.circularFilteredList.filteredNext(this::filterEvenNumber);
        assertEquals(2, next.get());
    }
}