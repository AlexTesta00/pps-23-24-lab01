package tdd;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BasicCircularList implements CircularList {

    private final static int INDEX_OF_FIRST_ELEMENT_IN_LIST = 0;
    private int nextElementIndex = INDEX_OF_FIRST_ELEMENT_IN_LIST;
    private final List<Integer> items = new ArrayList<>();

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

    private boolean isTheLastElement(){
        return this.nextElementIndex == this.getLastIndexOfList();
    }

    private void updateIndex(int index){
        this.nextElementIndex = index;
    }
    
    private Optional<Integer> getCurrentItem() {
        return Optional.of(this.items.get(this.nextElementIndex));
    }

    @Override
    public Optional<Integer> next() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        Optional<Integer> nextElementInList = this.getCurrentItem();
        if(isTheLastElement()){
            this.reset();
        }else{
            this.updateIndex(this.nextElementIndex + 1);
        }
        return nextElementInList;
    }

    private int getLastIndexOfList(){
        return this.size() - 1;
    }

    private boolean isTheFirstElement(){
        return this.nextElementIndex == INDEX_OF_FIRST_ELEMENT_IN_LIST;
    }

    @Override
    public Optional<Integer> previous() {
        if(this.isEmpty()){
            return Optional.empty();
        }
        if(this.isTheFirstElement()){
            this.updateIndex(this.items.size() - 1);
        }else{
            this.updateIndex(this.nextElementIndex - 1);
        }
        return this.getCurrentItem();
    }

    @Override
    public void reset() {
        this.nextElementIndex = INDEX_OF_FIRST_ELEMENT_IN_LIST;
    }

}
