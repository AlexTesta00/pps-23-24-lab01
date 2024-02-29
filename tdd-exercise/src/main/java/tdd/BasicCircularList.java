package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicCircularList implements CircularList {

    private final static int INDEX_OF_FIRST_ELEMENT_IN_LIST = 0;
    private final List<Integer> items = new ArrayList<>();
    private int nextElementIndex = INDEX_OF_FIRST_ELEMENT_IN_LIST;

    @Override
    public void add(int element) {
        this.items.add(element);
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        return this.items.isEmpty();
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        Optional<Integer> nextElementInList = Optional.of(this.items.get(nextElementIndex));
        if(isTheLastElement()){
            this.reset();
        }else{
            this.incrementNextElementIndex();
        }
        return nextElementInList;
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        if(isTheFirstElement()){
            return Optional.of(this.items.get(INDEX_OF_FIRST_ELEMENT_IN_LIST));
        }else{
            this.decremenetNextElementIndex();
            return Optional.of(this.items.get(this.nextElementIndex));
        }
    }

    @Override
    public void reset() {
        this.nextElementIndex = INDEX_OF_FIRST_ELEMENT_IN_LIST;
    }

    private int getLastIndexOfList(){
        return this.size() - 1;
    }

    private boolean isTheLastElement(){
        return this.nextElementIndex == this.getLastIndexOfList();
    }

    private boolean isTheFirstElement(){
        return this.nextElementIndex == INDEX_OF_FIRST_ELEMENT_IN_LIST;
    }

    private void incrementNextElementIndex(){
        this.nextElementIndex = this.nextElementIndex + 1;
    }

    private void decremenetNextElementIndex(){
        this.nextElementIndex = this.nextElementIndex - 1;
    }

}
