package iterator;

import java.util.Collections;
import java.util.Iterator;

import tdd.BasicCircularList;
import tdd.CircularList;

public class BasicCircularListWithIterator implements CircularListWithIterator{

    private CircularList circularList = new BasicCircularList();

    @Override
    public void add(int element) {
        this.circularList.add(element);
    }

    @Override
    public int size() {
        return this.circularList.size();
    }

    @Override
    public boolean isEmpty() {
        return this.circularList.isEmpty();
    }

    @Override
    public Iterator<Integer> forwardIterator() {
        if(this.isEmpty()){
            return Collections.emptyIterator();
        }

        //TODO: Implement the forward iterator
        return null;
    }

    @Override
    public Iterator<Integer> backwardIterator() {
        if(this.isEmpty()){
            return Collections.emptyIterator();
        }

        //TODO: Implement the backword iterator
        return null;
    }
}
